package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.ui.project.edit.EditProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class EditProjectActivity extends AbstractActivity implements EditProjectView.Presenter {
   // Used to obtain views, eventBus, placeController
   // Alternatively, could be injected via GIN
   private ClientFactory    clientFactory;
   private AppRequestFactory   requestFactory;

   private EditProjectPlace place;
   private EditProjectView  view;

   public EditProjectActivity(EditProjectPlace place, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.requestFactory = clientFactory.getRequestFactory();
      this.place = place;

      this.view = clientFactory.getEditProjectView();
      this.loadProject(place.getProjectID());
   }

   private void loadProject(String projectID) {
      int projectIdAsInt = Integer.valueOf(projectID);
      this.requestFactory.projectRequest().findProject(projectIdAsInt).fire( new Receiver<ProjectProxy>() {

         @Override
         public void onSuccess(ProjectProxy receivedProject) {
            //TODO catch empty project!
            view.setProject(receivedProject);
         }});
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
