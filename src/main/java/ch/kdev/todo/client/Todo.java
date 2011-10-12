package ch.kdev.todo.client;

import ch.kdev.todo.client.mapper.AppActivityMapper;
import ch.kdev.todo.client.mapper.AppPlaceHistoryMapper;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class Todo implements EntryPoint {

   private Place defaultPlace = new ManageProjectsPlace();

   /**
    * This is the entry point method.
    */
   public void onModuleLoad() {
      ClientFactoryDesktop clientFactory = GWT.create(ClientFactoryDesktop.class);

      EventBus eventBus = clientFactory.getEventBus();
      PlaceController placeController = clientFactory.getPlaceController();

      AppPresenter appController = clientFactory.getAppController();

      // initialize the request-factory
      // TODO possible with GIN?
      AppRequestFactory requestFactory = clientFactory.getRequestFactory();
      requestFactory.initialize(eventBus);

      // Vertical Master container Activity Mapper
      ActivityMapper mainActivityMapper = new AppActivityMapper(clientFactory);
      ActivityManager mainActivityManager = new ActivityManager(mainActivityMapper, eventBus);
      mainActivityManager.setDisplay(appController.getContentContainer());

      // Start PlaceHistoryHandler with our PlaceHistoryMapper
      AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
      PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
      historyHandler.register(placeController, eventBus, defaultPlace);

      // Add app layout to RootPanel
      RootLayoutPanel.get().add(appController.getMainLayoutPanel());

      // Goes to place represented on URL or default place
      historyHandler.handleCurrentHistory();
   }
}
