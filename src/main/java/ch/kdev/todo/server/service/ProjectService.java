package ch.kdev.todo.server.service;

import java.util.List;

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

   public Integer countProjects() {
      return 10;
   }

   public List<Project> findAll() {
      return null;
   }

   public Project findProject(Long id) {
      Project foundProject = null;
/*
      for (Project project : this.existingProject) {
         if (project.getId() == id) {
            foundProject = project;
            break;
         }
      }
 */

      return foundProject;
   }
   
}