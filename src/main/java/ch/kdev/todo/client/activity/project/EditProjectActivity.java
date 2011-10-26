package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.activity.BasePresenter;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.ui.project.edit.EditProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class EditProjectActivity extends BasePresenter implements EditProjectView.Presenter {
   // Used to obtain views, eventBus, placeController
   // Alternatively, could be injected via GIN
   private AppRequestFactory requestFactory;

   private EditProjectPlace  place;
   private EditProjectView   view;

   private ProjectProxy      project;

   public EditProjectActivity(EditProjectPlace place, ClientFactory clientFactory) {
      super(clientFactory);

      this.requestFactory = clientFactory.getRequestFactory();
      this.place = place;

      this.view = clientFactory.getEditProjectView();
      this.loadProject(place.getProjectID());
   }

   private void loadProject(String projectID) {
      long projectIdAsLong = Integer.valueOf(projectID);
      this.requestFactory.projectRequest().findProject(projectIdAsLong).fire(new Receiver<ProjectProxy>() {

         @Override
         public void onSuccess(ProjectProxy receivedProject) {
            project = receivedProject;
            view.setProjectAttributes(receivedProject);
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
      if (this.isManualNavigation()) {
         return null;
      }
      else {
         return "Please hold on. This activity is stopping.";
      }
   }

   @Override
   public void saveProject() {
      ProjectRequest projectRequest = requestFactory.projectRequest();

      ProjectProxy editableProject = projectRequest.edit(this.project);
      editableProject = this.view.getProjectAttributes(editableProject);

      projectRequest.update(editableProject.getId(), editableProject).fire(new Receiver<Void>() {

         @Override
         public void onSuccess(Void response) {
            goTo(new ViewProjectPlace(project.getId().toString()));
         }
      });
   }
}
