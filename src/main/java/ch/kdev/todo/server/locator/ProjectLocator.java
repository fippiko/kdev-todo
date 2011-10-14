package ch.kdev.todo.server.locator;

import ch.kdev.todo.domain.Project;

import com.google.web.bindery.requestfactory.shared.Locator;

public class ProjectLocator extends Locator<Project, Long> {

   @Override
   public Class<Project> getDomainType() {
      return Project.class;
   }

   @Override
   public Long getId(Project domainObject) {
      return domainObject.getId();
   }

   @Override
   public Class<Long> getIdType() {
      return long.class;
   }

   @Override
   public Object getVersion(Project domainObject) {
      return 1;
   }

   @Override
   public Project create(Class<? extends Project> clazz) {
      return new Project();
   }

   @Override
   public Project find(Class<? extends Project> clazz, Long id) {
      return new Project();
   }
}