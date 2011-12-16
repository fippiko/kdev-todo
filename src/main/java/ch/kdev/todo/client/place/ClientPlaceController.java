package ch.kdev.todo.client.place;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class ClientPlaceController extends PlaceController {

   @Inject
   public ClientPlaceController(EventBus eventBus) {
      super(eventBus);
      // TODO Auto-generated constructor stub
   }
}
