package ch.kdev.todo.shared.requestfactory;

import java.util.List;

import ch.kdev.todo.server.locator.ProjectServiceLocator;
import ch.kdev.todo.server.service.ProjectService;
import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = ProjectService.class, locator = ProjectServiceLocator.class)
public interface ProjectRequest extends RequestContext {

   Request<Integer> countProjects();

   Request<List<ProjectProxy>> findAll();

   Request<ProjectProxy> findProject(Long id);

   Request<Void> persist(ProjectProxy project);
   
   /*
    * InstanceRequest<ProjectProxy, Void> remove();
    */

}
