package ch.kdev.todo.server.locator;

import ch.kdev.todo.server.service.ProjectService;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class ProjectServiceLocator implements ServiceLocator {


   @Override
   public Object getInstance(Class<?> clazz) {
      return clazz.equals(ProjectService.class) ? new ProjectService() : null;
   }
}