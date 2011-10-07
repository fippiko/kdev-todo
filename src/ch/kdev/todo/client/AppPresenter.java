package ch.kdev.todo.client;

import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.ui.layout.AppLayout;
import ch.kdev.todo.client.ui.mainmenu.MainMenuView;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class AppPresenter implements AppLayout.Presenter, MainMenuView.Presenter{

   private ClientFactory clientFactory;
   /*
   private final PlaceController placeController;
   private AppLayout appLayout;
   private MainMenuView mainMenuView;
*/
   /*

   @Inject
   public AppPresenter(PlaceController placeController, AppLayout appLayout, MainMenuView mainMenuView) {
      this.appLayout = appLayout;
      this.placeController = placeController;
      this.mainMenuView = mainMenuView;
      
      this.appLayout.setPresenter(this);
      this.mainMenuView.setPresenter(this);
   }

   @Override
   public void gotoDefaultPlace() {
      placeController.goTo(new ManageProjectsPlace());
   }

   @Override
   public void gotoManageProjectsPlace() {
      placeController.goTo(new ManageProjectsPlace());
   }

   @Override
   public AcceptsOneWidget getContentContainer() {
      return appLayout.getContentContainer();
   }

   @Override
   public Widget getMainLayoutPanel() {
      return appLayout.getMainLayoutPanel();
   }

   @Override
   public MainMenuView getMainMenuView() {
      return this.mainMenuView;
   }
   */
   
   @Inject
   public AppPresenter(ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
   }

   @Override
   public void gotoDefaultPlace() {
      this.gotoManageProjectsPlace();
   }

   @Override
   public void gotoManageProjectsPlace() {
      this.clientFactory.getPlaceController().goTo(new ManageProjectsPlace());
   }

   @Override
   public AcceptsOneWidget getContentContainer() {
      return this.clientFactory.getAppLayout().getContentContainer();
   }

   @Override
   public Widget getMainLayoutPanel() {
      return this.clientFactory.getAppLayout().getMainLayoutPanel();
   }

   @Override
   public MainMenuView getMainMenuView() {
      return this.clientFactory.getMainMenuView();
   }
}
