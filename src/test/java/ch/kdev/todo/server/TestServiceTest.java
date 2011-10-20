package ch.kdev.todo.server;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import ch.kdev.todo.domain.Project;
import ch.kdev.todo.domain.Task;
import ch.kdev.todo.server.service.ProjectService;
import ch.kdev.todo.server.service.TaskService;

public class TestServiceTest extends TestCase {

   private final static String TASK_ADD_NAME           = "Test Task Name (generated by JUnit)";
   private final static String TASK_ADD_DESCRIPTION    = "Test Task Description (generated by JUnit) This task should not exist.";

   private final static String TASK_UPDATE_NAME        = "Updated Test Task Name (updated by JUnit)";
   private final static String TASK_UPDATE_DESCRIPTION = "Updated Test Task Description (updated by JUnit) This task should not exist.";

   private ProjectService      projectService;
   private TaskService         taskService;

   private Project             taskProject;

   @Override
   public void setUp() {
      this.taskService = new TaskService();

      this.projectService = new ProjectService();

      this.taskProject = new Project();
      this.taskProject.setName("temp");
      this.taskProject.setDescription("temp");
      this.projectService.persist(this.taskProject);
   }

   @Override
   protected void tearDown() throws Exception {
      super.tearDown();

      this.projectService.delete(taskProject);
   }

   @Test
   public void testProjectCRUD() {
      // C - Create
      Task taskToAdd = this.createNewTask(this.taskProject);
      this.taskService.persist(taskToAdd);

      // R - Read
      Task addedTask = this.taskService.findTask(taskToAdd.getId());

      assertEquals(TASK_ADD_NAME, addedTask.getName());
      assertEquals(TASK_ADD_DESCRIPTION, addedTask.getDescription());

      // U - Update
      addedTask.setName(TASK_UPDATE_NAME);
      addedTask.setDescription(TASK_UPDATE_DESCRIPTION);

      this.taskService.persist(addedTask);
      Task updatedTask = this.taskService.findTask(addedTask.getId());

      assertEquals(TASK_UPDATE_NAME, updatedTask.getName());
      assertEquals(TASK_UPDATE_DESCRIPTION, updatedTask.getDescription());

      // D - Delete
      this.taskService.delete(updatedTask);
   }

   @Test
   public void testFindAll() {
      // add some projects...
      Task taskToAdd1 = this.createNewTask(this.taskProject);
      Task taskToAdd2 = this.createNewTask(this.taskProject);
      Task taskToAdd3 = this.createNewTask(this.taskProject);

      this.taskService.persist(taskToAdd1);
      this.taskService.persist(taskToAdd2);
      this.taskService.persist(taskToAdd3);

      List<Task> allTasks = this.taskService.findAll();

      int foundTaskCount = 0;
      for (Task task : allTasks) {
         long taskId = task.getId();

         if (taskId == taskToAdd1.getId()) {
            foundTaskCount++;
         }
         if (taskId == taskToAdd2.getId()) {
            foundTaskCount++;
         }
         if (taskId == taskToAdd3.getId()) {
            foundTaskCount++;
         }
      }

      assertEquals(foundTaskCount, 3);
      assertTrue(this.taskService.countTasks() >= 3);

      // delete all created projects
      this.taskService.delete(taskToAdd1);
      this.taskService.delete(taskToAdd2);
      this.taskService.delete(taskToAdd3);
   }

   private Task createNewTask(Project project) {
      Task task = new Task();

      task.setName(TASK_ADD_NAME);
      task.setDescription(TASK_ADD_DESCRIPTION);
      task.setProject(project);

      return task;
   }

}
