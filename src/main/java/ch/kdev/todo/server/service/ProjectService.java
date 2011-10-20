package ch.kdev.todo.server.service;

import java.util.List;

import org.hibernate.Session;

import ch.kdev.todo.domain.Project;
import ch.kdev.todo.server.database.HibernateUtil;

public class ProjectService {

   public void persist(Project project) {
      Session session = HibernateUtil.getNewSession();

      session.save(project);

      session.getTransaction().commit();
   }

   public void delete(Long id) {
      Project tempProject = new Project();
      
      tempProject.setId(id);
      
      this.delete(tempProject);
   }
   
   public void delete(Project project) {
      Session session = HibernateUtil.getNewSession();

      session.delete(project);

      session.getTransaction().commit();
   }

   public Integer countProjects() {
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