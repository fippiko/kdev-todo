package ch.kdev.todo.client.activity.handler.base;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public abstract class BaseHandler implements IBaseHandler {

   @Inject
   private PlaceController placeController;

   public BaseHandler() {

   }

   public void goTo(Place place) {
      this.placeController.goTo(place);
   }
}
