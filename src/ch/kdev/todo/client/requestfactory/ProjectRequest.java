package ch.kdev.todo.client.requestfactory;

import java.util.List;

import ch.kdev.todo.client.proxy.ProjectProxy;
import ch.kdev.todo.server.domain.Project;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Project.class)
public interface ProjectRequest extends RequestContext {

   Request<Long> countProjects();

   Request<List<ProjectProxy>> getAllProjects();

   Request<ProjectProxy> getProject(Long id);

   InstanceRequest<ProjectProxy, Void> persist();

   InstanceRequest<ProjectProxy, Void> remove();

}
