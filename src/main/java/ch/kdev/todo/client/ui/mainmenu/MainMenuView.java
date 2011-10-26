package ch.kdev.todo.client.ui.mainmenu;

import com.google.gwt.user.client.ui.IsWidget;

public interface MainMenuView extends IsWidget {

   public interface Presenter {
      void gotoDefaultPlace();

      void gotoManageProjectsPlace();
   }
}
