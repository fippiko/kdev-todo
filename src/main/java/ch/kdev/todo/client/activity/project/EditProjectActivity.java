package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.activity.base.BaseActivity;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.project.edit.IEditProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.IRequestFactory;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class EditProjectActivity extends BaseActivity implements IEditProjectView.Presenter {
   @Inject
   private IRequestFactory requestFactory;

   @SuppressWarnings("unused")
   private EditProjectPlace  place;

   private IEditProjectView  view;

   private ProjectProxy      project;

   @Inject
   public EditProjectActivity(IViewFactory viewFactory) {
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
    * Ask user before stopping this activity
    */
   @Override
   public String mayStop() {
      if (this.view.hasChanges()) {
         return "Please hold on. You'll lose all changes.";
      }
      else {
         return null;
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

   @Override
   public IBaseView getView() {
      return this.view;
   }
}
