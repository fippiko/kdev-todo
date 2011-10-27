package ch.kdev.todo.client.view.project.view;

import ch.kdev.todo.client.activity.BasePresenterInterface;
import ch.kdev.todo.client.view.BaseViewInterface;
import ch.kdev.todo.shared.proxy.ProjectProxy;

public interface ViewProjectView extends BaseViewInterface {

   public interface Presenter extends BasePresenterInterface {
      void manageProjects();
      void editProject();
   }

   void setProjectAttributes(ProjectProxy project);
}
