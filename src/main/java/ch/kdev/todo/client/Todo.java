package ch.kdev.todo.client;

import ch.kdev.todo.shared.requestfactory.AppRequestFactory;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class Todo implements EntryPoint {

   /**
    * This is the entry point method.
    */
   public void onModuleLoad() {
      ClientFactoryDesktop clientFactory = GWT.create(ClientFactoryDesktop.class);

      EventBus eventBus = clientFactory.getEventBus();
      AppPresenter appPresenter = clientFactory.getAppPresenter();
      ActivityManager activityManager = clientFactory.getActivityManager();

      // initialize the request-factory
      // TODO possible with GIN?
      AppRequestFactory requestFactory = clientFactory.getRequestFactory();
      requestFactory.initialize(eventBus);

      // Set Display of the ActivityManager to the ContentContainer of the AppPresenter
      activityManager.setDisplay(appPresenter.getContentContainer());

      // Add app layout to RootPanel
      RootLayoutPanel.get().add(appPresenter.getMainLayoutPanel());

      // Goes to place represented on URL or default place
      clientFactory.getPlaceHistoryHandler().handleCurrentHistory();
   }
}
