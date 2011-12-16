package ch.kdev.todo.client.view.layout;

import ch.kdev.todo.client.view.mainmenu.MainMenuView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class AppLayout implements IAppLayout {

   private DockLayoutPanel mainLayoutPanel;

   interface AppLayoutUiBinder extends UiBinder<DockLayoutPanel, AppLayout> {
   }

   private static AppLayoutUiBinder binder = GWT.create(AppLayoutUiBinder.class);

   @UiField
   SimplePanel                      menuPanel;

   @UiField
   SimplePanel                      contentPanel;

   @UiField(provided = true)
   MainMenuView                     mainMenu;

   @UiField
   SimplePanel                      footerPanel;

   public AppLayout() {
   }

   @Override
   public void setPresenter(Presenter presenter) {
      mainMenu = (MainMenuView) presenter.getMainMenuView();
      mainMenu.setPresenter((ch.kdev.todo.client.view.mainmenu.IMainMenuView.Presenter) presenter);

      mainLayoutPanel = binder.createAndBindUi(this);
   }

   @Override
   public DockLayoutPanel getMainLayoutPanel() {
      return mainLayoutPanel;
   }

   @Override
   public AcceptsOneWidget getContentContainer() {
      return new AcceptsOneWidget() {
         @Override
         public void setWidget(IsWidget w) {
            Widget widget = Widget.asWidgetOrNull(w);
            contentPanel.setWidget(widget);
         }
      };
   }
}