package ch.kdev.todo.client.view.mainmenu;

import ch.kdev.todo.client.view.base.IPresenter;

public interface IMainMenuView {

   public interface Presenter extends IPresenter{
      void gotoDefaultPlace();

      void gotoManageProjectsPlace();

      void gotoAddTask();
   }

}
