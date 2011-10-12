package ch.kdev.todo.server.service;

import java.util.List;

import ch.kdev.todo.domain.Project;

public class ProjectService {
   List<Project> existingProject;

   public ProjectService(List<Project> existingProject) {
      this.existingProject = existingProject;
   }

   public Integer countProjects() {
      return this.existingProject.size();
   }

   public List<Project> findAll() {
      return this.existingProject;
   }

   public Project findProject(Integer id) {
      Project foundProject = null;

      for (Project project : this.existingProject) {
         if (project.getID() == id) {
            foundProject = project;
            break;
         }
      }

      return foundProject;
   }

}