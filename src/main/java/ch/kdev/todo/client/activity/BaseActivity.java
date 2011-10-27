package ch.kdev.todo.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class BaseActivity extends AbstractActivity {

   @Inject
   private PlaceController placeController;

   private Boolean         manualNavigation;

   public BaseActivity() {
      this.manualNavigation = false;
   }

   @Override
   public void start(AcceptsOneWidget panel, EventBus eventBus) {

   }

   public void goTo(Place place) {
      this.manualNavigation = true;
      this.placeController.goTo(place);
   }

   public Boolean isManualNavigation() {
      return this.manualNavigation;
   }

}
