package ch.kdev.todo.client.activity.project;

import ch.kdev.todo.client.activity.BaseActivity;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.view.ViewFactory;
import ch.kdev.todo.client.view.project.add.AddProjectView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class AddProjectActivity extends BaseActivity implements AddProjectView.Presenter {
   @Inject
   private ProjectRequest  projectRequest;

   @SuppressWarnings("unused")
   private AddProjectPlace place;

   //@Inject
   private AddProjectView  view;

   @Inject
   public AddProjectActivity(ViewFactory viewFactory){
      this.view = viewFactory.getAddProjectView();
   }

   public AddProjectActivity withPlace(AddProjectPlace place) {
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
            // TODO Auto-generated method stub
            super.onFailure(error);
         }
      });
   }
}
