package ch.kdev.todo.client.activity.task;

import java.util.List;

import ch.kdev.todo.client.activity.base.BaseActivity;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.place.task.AddTaskPlace;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.task.add.IAddTaskView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.proxy.TaskProxy;
import ch.kdev.todo.shared.requestfactory.IRequestFactory;
import ch.kdev.todo.shared.requestfactory.TaskRequest;

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
      TaskRequest taskRequest = this.requestFactory.taskRequest();
      TaskProxy newTask = taskRequest.create(TaskProxy.class);

      final Long projectId = this.view.getProjectId();

      newTask.setName(this.view.getTaskName());
      newTask.setDescription(this.view.getTaskDescription());

      taskRequest.persist(projectId, newTask).fire(new Receiver<Void>() {

         @Override
         public void onSuccess(Void arg0) {
            suppressLeaveWarning();
            goTo(new ViewProjectPlace(projectId));
         }

         @Override
         public void onFailure(ServerFailure error) {
            view.showError(error.getMessage());
            super.onFailure(error);
         }
      });
   }

   @Override
   public void initProjectList() {
      this.requestFactory.projectRequest().findAll().fire(new Receiver<List<ProjectProxy>>() {

         @Override
         public void onSuccess(List<ProjectProxy> response) {
            initProjectList(response);
         }
         @Override
         public void onFailure(ServerFailure error) {
            view.showError(error.getMessage());
            super.onFailure(error);
         }
      });
   }

   private void initProjectList(List<ProjectProxy> projectList) {
      for (ProjectProxy project : projectList) {
         this.view.addProject(project.getName(), project.getId().toString());
      }
   }
}
