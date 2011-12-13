package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.activity.BaseActivity;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.view.BaseViewInterface;
import ch.kdev.todo.client.view.ViewFactory;
import ch.kdev.todo.client.view.project.view.ViewProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class ViewProjectActivity extends BaseActivity implements ViewProjectView.Presenter {

   @Inject
   private AppRequestFactory requestFactory;

   private ViewProjectView  view;

   private ViewProjectPlace place;

   @Inject
   public ViewProjectActivity(ViewFactory viewFactory){
      this.view = viewFactory.getViewProjectView();
   }
   
   public ViewProjectActivity withPlace(ViewProjectPlace place) {
      this.place = place;
      this.loadProject(place.getProjectID());

      return this;
   }

   private void loadProject(String projectID) {
      long projectIdAsLong = Integer.valueOf(projectID);
      requestFactory.projectRequest().findProject(projectIdAsLong).fire(new Receiver<ProjectProxy>() {

         @Override
         public void onSuccess(ProjectProxy receivedProject) {
            view.setProjectAttributes(receivedProject);
         }
         
         @Override
         public void onFailure(ServerFailure error) {
            // TODO Auto-generated method stub
            super.onFailure(error);
         }
      });
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

   @Override
   public BaseViewInterface getView() {
      return this.view;
   }
}
