package ch.kdev.todo.client.view.project.view;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;

public interface IViewProjectView extends IBaseView {

   public interface Presenter extends IPresenter {
      void manageProjects();

      void editProject();
   }

   void setProjectName(String name);
   void setProjectDescription(String description);
   void addProjectTask(String task);
}
