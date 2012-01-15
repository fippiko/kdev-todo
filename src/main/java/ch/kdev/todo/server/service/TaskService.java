package ch.kdev.todo.server.service;

import java.util.List;

import org.hibernate.Session;

import ch.kdev.todo.domain.Project;
import ch.kdev.todo.domain.Task;

import com.allen_sauer.gwt.log.client.Log;

public class TaskService extends BaseService {

   public void persist(Long projectId, Task task) {
      Session session = this.getSessionManager().getNewSession();

      Project foundProject = (Project) session.get(Project.class, projectId);

      foundProject.addTask(task);

      session.save(task);
      session.save(foundProject);

      session.getTransaction().commit();
   }

   public void delete(Long taskId) {
      Log.debug("TaskService: delete task with ID:" + taskId);

      Session session = this.getSessionManager().getNewSession();

      Task taskToDelete = this.findTask(taskId);
      
      Project parentProject = taskToDelete.getProject();
      parentProject.getTasks().remove(taskToDelete);
      
      session.save(parentProject);
      session.delete(taskToDelete);

      session.getTransaction().commit();
   }

   public Integer countTasks() {
      Session session = this.getSessionManager().getNewSession();

      int count = ((Long) session.createQuery("select count(*) from Task").uniqueResult()).intValue();

      return count;
   }

   public List<Task> findAll() {
      Session session = this.getSessionManager().getNewSession();

      @SuppressWarnings("unchecked")
      List<Task> tasks = session.createQuery("from Task").list();
      session.getTransaction().commit();

      return tasks;
   }

   public Task findTask(Long taskId) {
      Session session = this.getSessionManager().getNewSession();

      Task foundTask = (Task) session.load(Task.class, taskId);

      return foundTask;
   }

}