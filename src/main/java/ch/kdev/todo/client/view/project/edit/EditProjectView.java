package ch.kdev.todo.client.view.project.edit;

import ch.kdev.todo.client.activity.BasePresenterInterface;
import ch.kdev.todo.client.view.BaseViewInterface;
import ch.kdev.todo.shared.proxy.ProjectProxy;

public interface EditProjectView extends BaseViewInterface {

   public interface Presenter extends BasePresenterInterface {
      void saveProject();
   }

   void setProjectAttributes(ProjectProxy project);

   ProjectProxy getProjectAttributes(ProjectProxy editableProject);
}
