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

   private boolean          suppressLeaveWarning;

   public BaseActivity() {
      suppressLeaveWarning = false;
   }

   /**
    * Invoked by the ActivityManager to start a new Activity
    */
   @Override
   public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
      this.getView().setPresenter(this);
      containerWidget.setWidget(this.getView().asWidget());
   }

   /**
    * Redirect to the ErrorHelp Activity
    */
   @Override
   public void handleError(String errorMessage) {
      // TODO implement
   }

   public void goTo(Place place) {
      activityFactory.getPlaceController().goTo(place);
      suppressLeaveWarning(false);
   }

   @Override
   public boolean isLeaveWarningSuppressed() {
      return suppressLeaveWarning;
   }

   @Override
   public void suppressLeaveWarning() {
      suppressLeaveWarning(true);
   }

   @Override
   public void suppressLeaveWarning(boolean suppress) {
      suppressLeaveWarning = suppress;
   }

   protected IActivityFactory getActivityFactory() {
      return this.activityFactory;
   }
}
