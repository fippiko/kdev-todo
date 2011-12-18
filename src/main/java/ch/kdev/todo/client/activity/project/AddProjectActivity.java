package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.activity.base.BaseActivity;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.project.add.IAddProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class AddProjectActivity extends BaseActivity implements IAddProjectView.Presenter {
   @Inject
   private ProjectRequest  projectRequest;

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
      if (this.view.hasChanges()) {
         return "Please hold on. You'll lose all changes.";
      }
      else {
         return null;
      }
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

         @Override
         public void onFailure(ServerFailure error) {
            view.showError(error.getMessage());
         }
      });
   }

   @Override
   public IBaseView getView() {
      return this.view;
   }
}
