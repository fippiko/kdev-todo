package ch.kdev.todo.server.service;

import java.util.List;

import org.hibernate.Session;

import ch.kdev.todo.domain.Task;
import ch.kdev.todo.server.database.HibernateUtil;

public class TaskService {

   public void persist(Task task) {
      Session session = HibernateUtil.getNewSession();

      session.save(task);

      session.getTransaction().commit();
   }

   public void delete(Task task) {
      Session session = HibernateUtil.getNewSession();

      session.delete(task);

      session.getTransaction().commit();
   }

   public Integer countTasks() {
      Session session = HibernateUtil.getNewSession();

      int count = ((Long) session.createQuery("select count(*) from Task").uniqueResult()).intValue();

      return count;
   }

   public List<Task> findAll() {
      Session session = HibernateUtil.getNewSession();

      @SuppressWarnings("unchecked")
      List<Task> tasks = session.createQuery("from Task").list();
      session.getTransaction().commit();

      return tasks;
   }

   public Task findTask(Long taskId) {
      Session session = HibernateUtil.getNewSession();

      Task foundTask = (Task) session.load(Task.class, taskId);

      return foundTask;
   }

}