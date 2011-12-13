package ch.kdev.todo.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public abstract class BaseActivity extends AbstractActivity implements BasePresenterInterface {

   @Inject
   private PlaceController   placeController;

   private Boolean           manualNavigation;

   public BaseActivity() {
      this.manualNavigation = false;
   }

   /**
    * Invoked by the ActivityManager to start a new Activity
    */
   @Override
   public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
      this.getView().setActivity(this);
      containerWidget.setWidget(this.getView().asWidget());
   }

   public void goTo(Place place) {
      this.manualNavigation = true;
      this.placeController.goTo(place);
   }

   public Boolean isManualNavigation() {
      return this.manualNavigation;
   }
}
