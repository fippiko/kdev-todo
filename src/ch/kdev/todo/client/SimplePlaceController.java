package ch.kdev.todo.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class SimplePlaceController extends PlaceController{

   @Inject
   public SimplePlaceController(EventBus eventBus) {
      super(eventBus);
      // TODO Auto-generated constructor stub
   }

}
