package ch.kdev.todo.client.view.layout;

import ch.kdev.todo.client.view.mainmenu.MainMenuView;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public interface AppLayout {

   DockLayoutPanel getMainLayoutPanel();

   AcceptsOneWidget getContentContainer();

   public interface Presenter {
      public AcceptsOneWidget getContentContainer();

      public Widget getMainLayoutPanel();

      public MainMenuView getMainMenuView();
   }

   void setPresenter(Presenter presenter);
}
