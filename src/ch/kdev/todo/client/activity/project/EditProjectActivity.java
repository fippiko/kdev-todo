package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.ui.project.edit.EditProjectView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class EditProjectActivity extends AbstractActivity implements EditProjectView.Presenter {
   // Used to obtain views, eventBus, placeController
   // Alternatively, could be injected via GIN
   private ClientFactory    clientFactory;

   private EditProjectPlace place;
   private EditProjectView  view;

   public EditProjectActivity(EditProjectPlace place, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.place = place;

      this.view = clientFactory.getEditProjectView();
      this.view.setProject(this.place.getProjectID());
   }

   /**
    * Invoked by the ActivityManager to start a new Activity
    */
   @Override
   public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
      this.view.setPresenter(this);
      containerWidget.setWidget(this.view.asWidget());
   }

   /**
    * Ask user before stopping this activity
    */
   @Override
   public String mayStop() {
      return "Please hold on. This activity is stopping.";
   }

   /**
    * Navigate to a new Place in the browser
    */
   public void goTo(Place place) {
      clientFactory.getPlaceController().goTo(place);
   }
}
