package ch.kdev.todo.client.activity.project;

import java.util.List;

import ch.kdev.todo.client.activity.base.BaseActivity;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.project.manage.IManageProjectsView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.IRequestFactory;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class ManageProjectsActivity extends BaseActivity implements IManageProjectsView.Presenter {

   @Inject
   IRequestFactory             requestFactory;

   @SuppressWarnings("unused")
   private ManageProjectsPlace place;

   private IManageProjectsView view;

   @Inject
   public ManageProjectsActivity(IViewFactory viewFactory) {
      this.view = viewFactory.getManageProjectsView();
   }

   public ManageProjectsActivity withPlace(ManageProjectsPlace place) {
      this.place = place;
      return this;
   }

   @Override
   public void reloadProjectList() {
      this.requestFactory.projectRequest().findAll().fire(new Receiver<List<ProjectProxy>>() {

         @Override
         public void onSuccess(List<ProjectProxy> response) {
            view.updateProjectList(response);
         }
      });
   }

   @Override
   public void deleteSelectedProject() {
      Long projectId = Long.valueOf(this.view.getSelectedProjectId());

      this.requestFactory.projectRequest().delete(projectId).fire(new Receiver<Void>() {

         @Override
         public void onSuccess(Void arg0) {
            reloadProjectList();
         }
      });
   }

   @Override
   public void editSelectedProject() {
      Long selectedProjectId = this.getSelectedProjectId();

      this.goTo(new EditProjectPlace(selectedProjectId));
   }

   @Override
   public void addNewProject() {
      this.goTo(new AddProjectPlace());
   }

   @Override
   public void viewSelectedProject() {
      Long selectedProjectId = this.getSelectedProjectId();

      this.goTo(new ViewProjectPlace(selectedProjectId));
   }

   private Long getSelectedProjectId() {
      String selectedProjectId = this.view.getSelectedProjectId();

      return Long.parseLong(selectedProjectId);
   }

   @Override
   public IBaseView getView() {
      return this.view;
   }
}
