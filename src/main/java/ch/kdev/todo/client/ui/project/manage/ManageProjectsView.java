package ch.kdev.todo.client.ui.project.manage;

import java.util.List;

import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.gwt.user.client.ui.IsWidget;

public interface ManageProjectsView extends IsWidget {

   void setPresenter(Presenter listener);

   public interface Presenter {
      void reloadProjectList();

      void deleteSelectedProject();

      void editSelectedProject();

      void addNewProject();
   }

   void updateProjectList(List<ProjectProxy> response);

   String getSelectedProjectId();
}
