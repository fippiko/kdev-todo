package ch.kdev.todo.client.activity;

import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.view.ViewFactory;
import ch.kdev.todo.client.view.layout.AppLayout;
import ch.kdev.todo.client.view.mainmenu.MainMenuView;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class AppActivity extends BaseActivity implements AppLayout.Presenter, MainMenuView.Presenter {

   @Inject
   private ViewFactory viewProvider;

   @Inject
   public AppActivity() {
      // this.viewProvider.getAppLayout().setPresenter(this);
      // register the content-container on the activity manager as display
      // this.getClientFactory().getActivityManager().setDisplay(this.getContentContainer());
   }

   @Override
   public void gotoDefaultPlace() {
      this.gotoManageProjectsPlace();
   }

   @Override
   public void gotoManageProjectsPlace() {
      this.goTo(new ManageProjectsPlace());
   }

   @Override
   public AcceptsOneWidget getContentContainer() {
      return this.getAppLayout().getContentContainer();
   }

   @Override
   public Widget getMainLayoutPanel() {
      return this.getAppLayout().getMainLayoutPanel();
   }

   private AppLayout getAppLayout() {
      AppLayout appLayout = this.viewProvider.getAppLayout();
      appLayout.setPresenter(this);
      return appLayout;
   }

   @Override
   public MainMenuView getMainMenuView() {
      return this.viewProvider.getMainMenuView();
   }
}
