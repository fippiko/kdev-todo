package ch.kdev.todo.client.view.project.view;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;
import ch.kdev.todo.shared.proxy.ProjectProxy;

public interface IViewProjectView extends IBaseView {

   public interface Presenter extends IPresenter {
      void manageProjects();

      void editProject();
   }

   void setProjectAttributes(ProjectProxy project);
}
