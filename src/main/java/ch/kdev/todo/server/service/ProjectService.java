package ch.kdev.todo.server.service;

import java.util.List;

import org.hibernate.Session;

import com.allen_sauer.gwt.log.client.Log;

import ch.kdev.todo.domain.Project;
import ch.kdev.todo.server.database.HibernateUtil;

/**
 * @author fippiko
 * 
 */
public class ProjectService {

   public void persist(Project project) {
      Log.debug("ProjectService: persisting project");
      
      Session session = HibernateUtil.getNewSession();

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
      Log.debug("ProjectService: update project ID:"+id);
      
      Project existingProject = findProject(id);
      
      Session session = HibernateUtil.getNewSession();

      session.clear();
      
      if(project.getName() != null){
         existingProject.setName(project.getName());
      }
      if(project.getDescription() != null){
         existingProject.setDescription(project.getDescription());
      }
      
      session.update(existingProject);

      session.getTransaction().commit();
   }

   public void delete(Long id) {
      Log.debug("ProjectService: delete project ID:"+id);
      
      Project tempProject = new Project();

      tempProject.setId(id);

      this.delete(tempProject);
   }

   public void delete(Project project) {
      Log.debug("ProjectService: delete project ID:"+project.getId());
      
      Session session = HibernateUtil.getNewSession();

      session.delete(project);

      session.getTransaction().commit();
   }

   public Integer countProjects() {
      Log.debug("ProjectService: count projects");
      
      Session session = HibernateUtil.getNewSession();

      int count = ((Long) session.createQuery("select count(*) from Project").uniqueResult()).intValue();

      return count;
   }

   public List<Project> findAll() {
      Session session = HibernateUtil.getNewSession();

      @SuppressWarnings("unchecked")
      List<Project> projects = session.createQuery("from Project").list();
      session.getTransaction().commit();

      return projects;
   }

   public Project findProject(Long projectId) {
      Session session = HibernateUtil.getNewSession();

      Project foundProject = (Project) session.load(Project.class, projectId);

      return foundProject;
   }

}