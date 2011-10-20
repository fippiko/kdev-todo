package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
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
   private ClientFactory     clientFactory;
   private AppRequestFactory requestFactory;

   private EditProjectPlace  place;
   private EditProjectView   view;

   private ProjectProxy projectToUpdate;
   
   private Boolean           manualNavigation;

   public EditProjectActivity(EditProjectPlace place, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.requestFactory = clientFactory.getRequestFactory();
      this.place = place;

      this.view = clientFactory.getEditProjectView();
      this.loadProject(place.getProjectID());

      this.manualNavigation = false;
   }

   private void loadProject(String projectID) {
      long projectIdAsLong = Integer.valueOf(projectID);
      this.requestFactory.projectRequest().findProject(projectIdAsLong).fire(new Receiver<ProjectProxy>() {

         @Override
         public void onSuccess(ProjectProxy receivedProject) {
            projectToUpdate = receivedProject;
            view.setProject(receivedProject);
         }
      });
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
      if (manualNavigation) {
         return null;
      }
      else {
         return "Please hold on. This activity is stopping.";
      }
   }

   /**
    * Navigate to a new Place in the browser
    */
   public void goTo(Place place) {
      this.manualNavigation = true;
      clientFactory.getPlaceController().goTo(place);
   }

   @Override
   public void saveProject() {

      this.projectToUpdate.setName(this.view.getUpdatedProjectName());
      this.projectToUpdate.setDescription(this.view.getUpdatedProjectDescription());
      
      this.requestFactory.projectRequest().persist(this.projectToUpdate).fire(new Receiver<Void>() {

         @Override
         public void onSuccess(Void response) {
            goTo(new ManageProjectsPlace());
         }
      });
   }
}
