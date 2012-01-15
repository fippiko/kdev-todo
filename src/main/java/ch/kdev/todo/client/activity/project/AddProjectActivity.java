package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.activity.base.BaseActivity;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.project.add.IAddProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.IRequestFactory;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class AddProjectActivity extends BaseActivity implements IAddProjectView.Presenter {
   @Inject
   private IRequestFactory requestFactory;

   @SuppressWarnings("unused")
   private AddProjectPlace place;

   private IAddProjectView view;

   @Inject
   public AddProjectActivity(IViewFactory viewFactory) {
      this.view = viewFactory.getAddProjectView();
   }

   public AddProjectActivity withPlace(AddProjectPlace place) {
      this.place = place;
      return this;
   }

   /**
    * Ask user before stopping this activity
    */
   @Override
   public String mayStop() {
      if (!this.isLeaveWarningSuppressed()) {
         if (this.view.hasChanges()) {
            return "Please hold on. You'll lose all changes.";
         }
      }

      return null;
   }

   @Override
   // public void addNewProject(String projectName, String projectDescription) {
   public void addNewProject() {
      ProjectRequest projectRequest = this.requestFactory.projectRequest();
      ProjectProxy newProject = projectRequest.create(ProjectProxy.class);

      newProject.setName(this.view.getProjectName());
      newProject.setDescription(this.view.getProjectDescription());

      projectRequest.persist(newProject).fire(new Receiver<Void>() {

         @Override
         public void onSuccess(Void arg0) {
            suppressLeaveWarning();
            goTo(new ManageProjectsPlace());
         }

         @Override
         public void onFailure(ServerFailure error) {
            view.showError(error.getMessage());
            super.onFailure(error);
         }
      });
   }

   @Override
   public IBaseView getView() {
      return this.view;
   }
}
