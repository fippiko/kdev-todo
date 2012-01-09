package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.factory.IActivityFactory;
import ch.kdev.todo.client.activity.main.MainActivity;
import ch.kdev.todo.client.factory.ClientFactoryProvider;
import ch.kdev.todo.client.factory.IClientFactory;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class Todo implements EntryPoint {

   /**
    * This is the entry point method.
    */
   @Override
   public void onModuleLoad() {
      IClientFactory clientFactory = new ClientFactoryProvider().get();

      // IViewFactory viewFactory = clientFactory.getViewFactory();
      IActivityFactory activityFactory = clientFactory.getActivityFactory();
      MainActivity appPresenter = activityFactory.getMainActivity();
      ActivityManager activityManager = activityFactory.getActivityManager();

      // Set Display of the ActivityManager to the ContentContainer of the
      // AppPresenter
      activityManager.setDisplay(appPresenter.getContentContainer());

      // Add app layout to RootPanel
      RootLayoutPanel.get().add(appPresenter.getMainLayoutPanel());

      // TODO temp:
      PlaceController placeController = activityFactory.getPlaceController();
      EventBus eventBus = activityFactory.getEventBus();
      activityFactory.getPlaceHistoryHandler().register(placeController, eventBus, new ManageProjectsPlace());

      // Goes to place represented on URL or default place
      activityFactory.getPlaceHistoryHandler().handleCurrentHistory();
   }
}
