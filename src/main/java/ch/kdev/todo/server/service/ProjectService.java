package ch.kdev.todo.server.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ch.kdev.todo.domain.Project;
import ch.kdev.todo.server.database.HibernateUtil;

public class ProjectService {
   
   public void persist(Project project){
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      
      session.save(project);
      
      session.getTransaction().commit();
   }
   
   public void delete(Project project){
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      
      session.delete(project);
      
      session.getTransaction().commit();
   }

   public Integer countProjects() {
      return 10;
   }

   public List<Project> findAll() {
      return null;
   }

   public Project findProject(Long projectId) {
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      
      Project foundProject = (Project) session.load(Project.class, projectId);
            
      return foundProject;
   }
   
}