package ch.kdev.todo.client.activity.project;

import java.util.List;

import ch.kdev.todo.client.activity.BaseActivity;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;
import ch.kdev.todo.client.view.project.manage.ManageProjectsView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class ManageProjectsActivity extends BaseActivity implements ManageProjectsView.Presenter {

   // @Inject
   // private AppRequestFactory requestFactory;

   @Inject
   AppRequestFactory           requestFactory;

   @SuppressWarnings("unused")
   private ManageProjectsPlace place;

   @Inject
   private ManageProjectsView  view;

   public ManageProjectsActivity withPlace(ManageProjectsPlace place) {
      this.place = place;
      return this;
   }

   /**
    * Invoked by the ActivityManager to start a new Activity
    */
   @Override
   public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
      this.view.setPresenter(this);
      containerWidget.setWidget(this.view.asWidget());
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
      String selectedProjectId = this.view.getSelectedProjectId();

      this.goTo(new EditProjectPlace(selectedProjectId));
   }

   @Override
   public void addNewProject() {
      this.goTo(new AddProjectPlace());
   }

   @Override
   public void viewSelectedProject() {
      String selectedProjectId = this.view.getSelectedProjectId();

      this.goTo(new ViewProjectPlace(selectedProjectId));
   }
}
