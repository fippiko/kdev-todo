package ch.kdev.todo.client.ui.layout;

import ch.kdev.todo.client.ui.mainmenu.MainMenuViewDesktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class AppLayoutDesktop implements AppLayout {

   private final DockLayoutPanel mainLayoutPanel;

   interface AppLayoutUiBinder extends UiBinder<DockLayoutPanel, AppLayoutDesktop> {
   }

   private static AppLayoutUiBinder binder = GWT.create(AppLayoutUiBinder.class);

   @UiField
   SimplePanel                      menuPanel;

   @UiField
   SimplePanel                      contentPanel;

   @UiField(provided = true)
   MainMenuViewDesktop              mainMenu;

   @UiField
   SimplePanel                      footerPanel;

   @Inject
   public AppLayoutDesktop(Presenter presenter) {
      mainMenu = (MainMenuViewDesktop) presenter.getMainMenuView();
      
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