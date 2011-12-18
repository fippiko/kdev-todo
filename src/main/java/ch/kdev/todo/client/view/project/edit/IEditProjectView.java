package ch.kdev.todo.client.view.project.edit;

import ch.kdev.todo.client.activity.base.IBaseActivity;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.shared.proxy.ProjectProxy;

public interface IEditProjectView extends IBaseView {

   public interface Presenter extends IBaseActivity {
      void saveProject();
   }

   void setProjectAttributes(ProjectProxy project);

   ProjectProxy getProjectAttributes(ProjectProxy editableProject);

   boolean hasChanges();
}
