package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.ui.project.add.AddProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class AddProjectActivity extends AbstractActivity implements AddProjectView.Presenter {
   // Used to obtain views, eventBus, placeController
   // Alternatively, could be injected via GIN
   private ClientFactory   clientFactory;
   private ProjectRequest  projectRequest;

   private AddProjectPlace place;
   private AddProjectView  view;
   
   private Boolean manualNavigation;

   public AddProjectActivity(AddProjectPlace place, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.projectRequest = clientFactory.getRequestFactory().projectRequest();

      this.place = place;
      this.view = clientFactory.getAddProjectView();
      
      this.manualNavigation = false;
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
      if(manualNavigation){
         return null;
      }
      else{
         return "Please hold on. This activity is stopping.";
      }
   }

   /**
    * Navigate to a new Place in the browser
    */
   public void goTo(Place place) {
      manualNavigation = true;
      clientFactory.getPlaceController().goTo(place);
   }

   @Override
   public void addNewProject(String projectName, String projectDescription) {

      ProjectProxy newProject = this.projectRequest.create(ProjectProxy.class);

      newProject.setName(projectName);
      newProject.setDescription(projectDescription);

      this.projectRequest.persist(newProject).fire(new Receiver<Void>() {

         @Override
         public void onSuccess(Void arg0) {
            goTo(new ManageProjectsPlace());
         }
      });
   }
}
