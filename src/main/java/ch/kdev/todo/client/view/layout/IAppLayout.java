package ch.kdev.todo.client.view.layout;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;
import ch.kdev.todo.client.view.mainmenu.IMainMenuView;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public interface IAppLayout extends IBaseView {

   public interface Presenter extends IPresenter {
      public AcceptsOneWidget getContentContainer();

      public Widget getMainLayoutPanel();

      public IMainMenuView getMainMenuView();
   }

   DockLayoutPanel getMainLayoutPanel();

   AcceptsOneWidget getContentContainer();
}
