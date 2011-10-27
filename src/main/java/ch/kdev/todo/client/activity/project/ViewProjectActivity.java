package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.activity.BaseActivity;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.view.project.view.ViewProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class ViewProjectActivity extends BaseActivity implements ViewProjectView.Presenter {

   @Inject
   private ProjectRequest   projectRequest;

   @Inject
   private ViewProjectView  view;

   private ViewProjectPlace place;

   public ViewProjectActivity withPlace(ViewProjectPlace place) {
      this.place = place;
      this.loadProject(place.getProjectID());

      return this;
   }

   private void loadProject(String projectID) {
      long projectIdAsLong = Integer.valueOf(projectID);
      projectRequest.findProject(projectIdAsLong).fire(new Receiver<ProjectProxy>() {

         @Override
         public void onSuccess(ProjectProxy receivedProject) {
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
   public void editProject() {
      this.goTo(new EditProjectPlace(this.place.getProjectID()));
   }

   @Override
   public void manageProjects() {
      this.goTo(new ManageProjectsPlace());
   }
}
