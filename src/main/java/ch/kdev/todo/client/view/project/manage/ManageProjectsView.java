package ch.kdev.todo.client.view.project.manage;

import java.util.List;

import ch.kdev.todo.client.activity.BasePresenterInterface;
import ch.kdev.todo.client.view.BaseViewInterface;
import ch.kdev.todo.shared.proxy.ProjectProxy;

public interface ManageProjectsView extends BaseViewInterface {

   public interface Presenter extends BasePresenterInterface {
      void reloadProjectList();

      void deleteSelectedProject();

      void editSelectedProject();

      void addNewProject();

      void viewSelectedProject();
   }

   void updateProjectList(List<ProjectProxy> response);

   String getSelectedProjectId();
}
