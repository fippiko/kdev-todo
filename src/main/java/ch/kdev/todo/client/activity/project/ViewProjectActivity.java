package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.activity.base.BaseActivity;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.project.view.IViewProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.proxy.TaskProxy;
import ch.kdev.todo.shared.requestfactory.IRequestFactory;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class ViewProjectActivity extends BaseActivity implements IViewProjectView.Presenter {

   @Inject
   private IRequestFactory  requestFactory;

   private IViewProjectView view;

   private ViewProjectPlace place;

   @Inject
   public ViewProjectActivity(IViewFactory viewFactory) {
      this.view = viewFactory.getViewProjectView();
   }

   public ViewProjectActivity withPlace(ViewProjectPlace place) {
      this.place = place;
      this.loadProject(place.getProjectId());

      return this;
   }

   private void loadProject(Long projectID) {
      requestFactory.projectRequest().findProject(projectID).fire(new Receiver<ProjectProxy>() {

         @Override
         public void onSuccess(ProjectProxy receivedProject) {
            setProject(receivedProject);
         }

         @Override
         public void onFailure(ServerFailure error) {
            // TODO Auto-generated method stub
            super.onFailure(error);
         }
      });
   }

   private void setProject(ProjectProxy project) {
      this.view.setProjectName(project.getName());
      this.view.setProjectDescription(project.getDescription());

      if (project.getTasks() != null) {
         for (TaskProxy task : project.getTasks()) {
            this.view.addProjectTask(task.getName());
         }
      }
   }

   @Override
   public void editProject() {
      this.goTo(new EditProjectPlace(this.place.getProjectId()));
   }

   @Override
   public void manageProjects() {
      this.goTo(new ManageProjectsPlace());
   }

   @Override
   public IBaseView getView() {
      return this.view;
   }
}
