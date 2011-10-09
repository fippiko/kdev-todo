package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.ui.project.add.AddProjectView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AddProjectActivity extends AbstractActivity implements AddProjectView.Presenter {
   // Used to obtain views, eventBus, placeController
   // Alternatively, could be injected via GIN
   private ClientFactory   clientFactory;

   private AddProjectPlace place;
   private AddProjectView  view;

   public AddProjectActivity(AddProjectPlace place, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.place = place;

      this.view = clientFactory.getAddProjectView();
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
      // TODO check message
      return "Please hold on. This activity is stopping.";
   }

   /**
    * Navigate to a new Place in the browser
    */
   public void goTo(Place place) {
      clientFactory.getPlaceController().goTo(place);
   }

   @Override
   public void addNewProject(String projectName, String projectDescription) {
      // TODO add new project here
   }
}
