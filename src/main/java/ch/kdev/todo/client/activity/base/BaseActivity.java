package ch.kdev.todo.client.activity.base;

import ch.kdev.todo.client.activity.factory.IActivityFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public abstract class BaseActivity extends AbstractActivity implements IBaseActivity {

   @Inject
   private IActivityFactory activityFactory;

   public BaseActivity() {

   }

   /**
    * Invoked by the ActivityManager to start a new Activity
    */
   @Override
   public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
      this.getView().setActivity(this);
      containerWidget.setWidget(this.getView().asWidget());
   }
   
   /**
    * Redirect to the ErrorHelp Activity
    */
   public void handleError(String errorMessage){
      
   }

   public void goTo(Place place) {
      this.activityFactory.getPlaceController().goTo(place);
   }
}
