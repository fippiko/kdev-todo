package ch.kdev.todo.server.service;

import java.util.List;

import org.hibernate.Session;

import ch.kdev.todo.domain.Project;

import com.allen_sauer.gwt.log.client.Log;

/**
 * @author fippiko
 * 
 */
public class ProjectService extends BaseService{

   public void persist(Project project) {
      Log.debug("ProjectService: persisting project");

      Session session = this.getSessionManager().getNewSession();

      session.save(project);

      session.getTransaction().commit();
   }

   /**
    * @param id
    *        The id of the Project to update ( needed because the RequestContext
    *        only sends the deltas to the server)
    * @param project
    *        The new values of the project
    * 
    *        Updates a existing project with the new values
    */
   public void update(Long id, Project project) {
      Log.debug("ProjectService: update project ID:" + id);

      Project existingProject = findProject(id);

      existingProject = (Project) ServiceHelper.mergeObjectWithDelta(Project.class, existingProject, project);
      existingProject.setVersion(existingProject.getVersion() + 1);

      Session session = this.getSessionManager().getNewSession();

      session.update(existingProject);

      session.getTransaction().commit();
   }

   public void delete(Long projectId) {
      Log.debug("ProjectService: delete project ID:" + projectId);

      Project projectToDelete = this.findProject(projectId);

      this.delete(projectToDelete);
   }

   public void delete(Project project) {
      Log.debug("ProjectService: delete project ID:" + project.getId());

      Session session = this.getSessionManager().getNewSession();

      session.delete(project);

      session.getTransaction().commit();
   }

   public Integer countProjects() {
      Log.debug("ProjectService: count projects");

      Session session = this.getSessionManager().getNewSession();

      int count = ((Long) session.createQuery("select count(*) from Project").uniqueResult()).intValue();

      return count;
   }

   public List<Project> findAll() {
      Session session = this.getSessionManager().getNewSession();

      @SuppressWarnings("unchecked")
      List<Project> projects = session.createQuery("from Project").list();
      session.getTransaction().commit();

      return projects;
   }

   public Project findProject(Long projectId) {
      Session session = this.getSessionManager().getNewSession();

      Project foundProject = (Project) session.get(Project.class, projectId);

      return foundProject;
   }

}