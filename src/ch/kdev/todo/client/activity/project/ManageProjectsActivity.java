package ch.kdev.todo.client.activity.project;

import java.util.ArrayList;
import java.util.List;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.ui.project.manage.ManageProjectsView;
import ch.kdev.todo.shared.model.Project;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ManageProjectsActivity extends AbstractActivity implements ManageProjectsView.Presenter {
   // Used to obtain views, eventBus, placeController
   // Alternatively, could be injected via GIN
   private ClientFactory       clientFactory;

   @SuppressWarnings("unused")
   private ManageProjectsPlace place;
   private ManageProjectsView  view;

   public ManageProjectsActivity(ManageProjectsPlace place, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.place = place;

      this.view = clientFactory.getManageProjectsView();
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
    * Navigate to a new Place in the browser
    */
   public void goTo(Place place) {
      clientFactory.getPlaceController().goTo(place);
   }

   @Override
   public List<Project> getProjects() {
      List<Project> allProjects = new ArrayList<Project>();

      allProjects.add(new Project("1", "Test1", "Description of Test1"));
      allProjects.add(new Project("2", "Test2", "Description of Test2"));
      allProjects.add(new Project("3", "Test3", "Description of Test3"));
      allProjects.add(new Project("4", "Test4", "Description of Test4"));

      return allProjects;
   }
}
