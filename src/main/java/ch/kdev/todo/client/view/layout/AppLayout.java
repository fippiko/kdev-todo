package ch.kdev.todo.client.view.layout;

import ch.kdev.todo.client.activity.base.IBaseActivity;
import ch.kdev.todo.client.view.base.BaseView;
import ch.kdev.todo.client.view.mainmenu.MainMenuView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class AppLayout extends BaseView<IAppLayout.Presenter> implements IAppLayout {

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
   public void setPresenter(IBaseActivity baseActivity) {
      super.setPresenter(baseActivity);

      mainMenu = (MainMenuView) getPresenter().getMainMenuView();
      // the mainmenu and applayout share the same presenter
      // because of this, this cast is possible
      mainMenu.setPresenter((IBaseActivity) baseActivity);

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