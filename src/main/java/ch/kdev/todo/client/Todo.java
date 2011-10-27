package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.ActivityFactory;
import ch.kdev.todo.client.activity.AppActivity;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Todo implements EntryPoint {

   /**
    * This is the entry point method.
    */
   public void onModuleLoad() {
      ClientFactoryDesktop clientFactory = GWT.create(ClientFactoryDesktop.class);

      ActivityFactory activityProvider = clientFactory.getActivityProvider();
      AppActivity appPresenter = activityProvider.getAppActivity();
      ActivityManager activityManager = activityProvider.getActivityManager();

      // initialize the request-factory
      // TODO possible with GIN?
      // AppRequestFactory requestFactory = clientFactory.getRequestFactory();
      // requestFactory.initialize(eventBus);

      // Set Display of the ActivityManager to the ContentContainer of the
      // AppPresenter
      activityManager.setDisplay(appPresenter.getContentContainer());

      // Add app layout to RootPanel
      RootLayoutPanel.get().add(appPresenter.getMainLayoutPanel());

      // TODO temp:
      PlaceController placeController = activityProvider.getPlaceController();
      activityProvider.getPlaceHistoryHandler().register(placeController, activityProvider.getEventBus(), new ManageProjectsPlace());

      // Goes to place represented on URL or default place
      activityProvider.getPlaceHistoryHandler().handleCurrentHistory();
   }
}
