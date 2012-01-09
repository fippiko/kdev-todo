package ch.kdev.todo.client.view.project.manage;

import java.util.List;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;
import ch.kdev.todo.shared.proxy.ProjectProxy;

public interface IManageProjectsView extends IBaseView {

   public interface Presenter extends IPresenter {
      void reloadProjectList();

      void deleteSelectedProject();

      void editSelectedProject();

      void addNewProject();

      void viewSelectedProject();
   }

   void updateProjectList(List<ProjectProxy> response);

   String getSelectedProjectId();
}
