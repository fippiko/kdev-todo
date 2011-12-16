package ch.kdev.todo.client.view.mainmenu;

import com.google.gwt.user.client.ui.IsWidget;

public interface IMainMenuView extends IsWidget {

   public interface Presenter {

      void gotoDefaultPlace();

      void gotoManageProjectsPlace();
   }

   void setPresenter(Presenter presenter);
}
