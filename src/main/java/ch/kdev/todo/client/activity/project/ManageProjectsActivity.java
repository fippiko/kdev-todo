package ch.kdev.todo.client.activity.project;

import java.util.List;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.ui.project.manage.ManageProjectsView;
import ch.kdev.todo.shared.proxy.ProjectProxy;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class ManageProjectsActivity extends AbstractActivity implements ManageProjectsView.Presenter {
   // Used to obtain views, eventBus, placeController
   // Alternatively, could be injected via GIN
   private ClientFactory       clientFactory;
   private AppRequestFactory   requestFactory;

   @SuppressWarnings("unused")
   private ManageProjectsPlace place;
   private ManageProjectsView  view;

   public ManageProjectsActivity(ManageProjectsPlace place, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.requestFactory = clientFactory.getRequestFactory();
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
   public void reloadProjectList() {

      this.requestFactory.projectRequest().findAll().fire(new Receiver<List<ProjectProxy>>() {

         @Override
         public void onSuccess(List<ProjectProxy> response) {
            view.updateProjectList(response);
         }
      });
   }
}
