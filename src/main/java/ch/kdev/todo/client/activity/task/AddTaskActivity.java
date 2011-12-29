package ch.kdev.todo.client.activity.task;

import java.util.List;

import ch.kdev.todo.client.activity.base.BaseActivity;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.place.task.AddTaskPlace;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.task.add.IAddTaskView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.IRequestFactory;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class AddTaskActivity extends BaseActivity implements IAddTaskView.Presenter {

   @Inject
   IRequestFactory      requestFactory;

   @SuppressWarnings("unused")
   private AddTaskPlace place;

   private IAddTaskView view;

   @Inject
   public AddTaskActivity(IViewFactory viewFactory) {
      this.view = viewFactory.getAddTaskView();
   }

   public AddTaskActivity withPlace(AddTaskPlace place) {
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
   public IBaseView getView() {
      return this.view;
   }

   @Override
   public void addNewTask() {
      ProjectRequest projectRequest = this.requestFactory.projectRequest();
      ProjectProxy newProject = projectRequest.create(ProjectProxy.class);

      newProject.setName(this.view.getTaskName());
      newProject.setDescription(this.view.getTaskDescription());

      projectRequest.persist(newProject).fire(new Receiver<Void>() {

         @Override
         public void onSuccess(Void arg0) {
            suppressLeaveWarning();
            goTo(new ManageProjectsPlace());
         }

         @Override
         public void onFailure(ServerFailure error) {
            view.showError(error.getMessage());
         }
      });
   }

   @Override
   public void initProjectList() {
      this.requestFactory.projectRequest().findAll().fire(new Receiver<List<ProjectProxy>>() {

         @Override
         public void onSuccess(List<ProjectProxy> response) {
            view.initProjectList(response);
         }
      });
   }
}
