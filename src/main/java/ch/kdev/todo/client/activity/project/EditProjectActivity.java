package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.activity.BaseActivity;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.view.ViewFactory;
import ch.kdev.todo.client.view.project.edit.EditProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class EditProjectActivity extends BaseActivity implements EditProjectView.Presenter {
   @Inject
   private AppRequestFactory requestFactory;

   @SuppressWarnings("unused")
   private EditProjectPlace  place;

   private EditProjectView   view;

   private ProjectProxy      project;

   @Inject
   public EditProjectActivity(ViewFactory viewFactory){
      this.view = viewFactory.getEditProjectView();
   }
   
   public EditProjectActivity withPlace(EditProjectPlace place) {
      this.place = place;
      this.loadProject(place.getProjectID());

      return this;
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
         
         @Override
         public void onFailure(ServerFailure error) {
            // TODO Auto-generated method stub
            super.onFailure(error);
         }
      });
   }
}
