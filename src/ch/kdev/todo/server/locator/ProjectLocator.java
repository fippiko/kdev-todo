package ch.kdev.todo.server.locator;

import ch.kdev.todo.server.domain.Project;

import com.google.web.bindery.requestfactory.shared.Locator;

public class ProjectLocator extends Locator<Project, Long> {
   @Override
   public Project create(Class<? extends Project> clazz) {
      return new Project("test", "test", "test");
   }

   @Override
   public Project find(Class<? extends Project> clazz, Long id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Class<Project> getDomainType() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long getId(Project domainObject) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Class<Long> getIdType() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Object getVersion(Project domainObject) {
      // TODO Auto-generated method stub
      return null;
   }
}