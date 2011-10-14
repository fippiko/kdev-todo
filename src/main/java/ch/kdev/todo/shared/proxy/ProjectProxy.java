package ch.kdev.todo.shared.proxy;

import ch.kdev.todo.domain.Project;
import ch.kdev.todo.server.locator.ProjectLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Project.class, locator = ProjectLocator.class)
public interface ProjectProxy extends EntityProxy {

   public Long getId();

   public void setId(Long id);

   public String getName();

   public void setName(String name);

   public String getDescription();

   public void setDescription(String description);
}
