package ch.kdev.todo.client.mapper;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class AppPlaceHistoryHandler extends PlaceHistoryHandler {

   @Inject
   public AppPlaceHistoryHandler(PlaceHistoryMapper mapper) {
      super(mapper);
   }

   // @Inject
   @Override
   public HandlerRegistration register(PlaceController placeController, EventBus eventBus, Place defaultPlace) {
      return super.register(placeController, eventBus, defaultPlace);

      // TODO Temporary!!!
   }
}
