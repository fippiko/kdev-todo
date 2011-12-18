package ch.kdev.todo.client.view.project.view;

import ch.kdev.todo.client.activity.base.IBaseActivity;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.shared.proxy.ProjectProxy;

public interface IViewProjectView extends IBaseView {

   public interface Presenter extends IBaseActivity {
      void manageProjects();
      void editProject();
   }

   void setProjectAttributes(ProjectProxy project);
}
