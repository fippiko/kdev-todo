package ch.kdev.todo.server.locator;

import java.util.ArrayList;
import java.util.List;

import ch.kdev.todo.domain.Project;
import ch.kdev.todo.server.service.ProjectService;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class ProjectServiceLocator implements ServiceLocator {

   private List<Project> existingProject;

   public ProjectServiceLocator() {
      this.existingProject = new ArrayList<Project>();
      for (int i = 0; i < 10; i++) {
         Project newProject = new Project();
         newProject.setID(i);
         newProject.setName("Name of Project" + i);
         newProject.setDescription("Description of Project" + i);
         this.existingProject.add(newProject);
      }
   }

   @Override
   public Object getInstance(Class<?> clazz) {
      return clazz.equals(ProjectService.class) ? new ProjectService(this.existingProject) : null;
   }
}