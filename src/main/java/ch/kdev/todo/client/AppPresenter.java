package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.BasePresenter;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.ui.layout.AppLayout;
import ch.kdev.todo.client.ui.mainmenu.MainMenuView;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class AppPresenter extends BasePresenter implements AppLayout.Presenter, MainMenuView.Presenter {

   @Inject
   public AppPresenter(ClientFactory clientFactory) {
      super(clientFactory);
      
      //register the content-container on the activity manager as display
      //this.getClientFactory().getActivityManager().setDisplay(this.getContentContainer());
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
      return this.getClientFactory().getAppLayout().getContentContainer();
   }

   @Override
   public Widget getMainLayoutPanel() {
      return this.getClientFactory().getAppLayout().getMainLayoutPanel();
   }

   @Override
   public MainMenuView getMainMenuView() {
      return this.getClientFactory().getMainMenuView();
   }
}
