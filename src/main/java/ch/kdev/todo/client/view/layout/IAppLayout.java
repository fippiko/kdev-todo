package ch.kdev.todo.client.view.layout;

import ch.kdev.todo.client.view.mainmenu.IMainMenuView;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public interface IAppLayout {

   DockLayoutPanel getMainLayoutPanel();

   AcceptsOneWidget getContentContainer();

   public interface Presenter {
      public AcceptsOneWidget getContentContainer();

      public Widget getMainLayoutPanel();

      public IMainMenuView getMainMenuView();
   }

   void setPresenter(Presenter presenter);
}
