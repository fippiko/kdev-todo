package ch.kdev.todo.client.proxy;

import ch.kdev.todo.server.domain.Project;
import ch.kdev.todo.server.locator.ProjectLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Project.class, locator = ProjectLocator.class)
public interface ProjectProxy extends EntityProxy {

   public String getID();

   public void setID(String id);

   public String getName();

   public void setName(String name);

   public String getDescription();

   public void setDescription(String description);
}
