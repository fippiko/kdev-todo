package ch.kdev.todo.client.view.project.manage;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;

public interface IManageProjectsView extends IBaseView {

   public interface Presenter extends IPresenter {
      void reloadProjectList();

      void deleteSelectedProject();

      void editSelectedProject();

      void addNewProject();

      void viewSelectedProject();
   }

   void addProjectListItem(String projectName, String projectDescription, String projectId);
   //void updateProjectList(List<ProjectProxy> projects);

   String getSelectedProjectId();

   void clearProjectList();
}
