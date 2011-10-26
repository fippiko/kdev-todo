package ch.kdev.todo.client.mapper;


import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.activity.project.AddProjectActivity;
import ch.kdev.todo.client.activity.project.EditProjectActivity;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.activity.project.ViewProjectActivity;
import ch.kdev.todo.client.activity.provider.AddProjectActivityProvider;
import ch.kdev.todo.client.activity.provider.ManageProjectsActivityProvider;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

public class AppActivityMapper implements ActivityMapper {

   @Inject
   private ClientFactory clientFactory;
   
   @Inject
   private ManageProjectsActivityProvider manageProjectsActivityProvider;
   
   @Inject
   private AddProjectActivityProvider addProjectActivityProvider;
   
   /**
    * Map each Place to its corresponding Activity.
    */
   @Override
   public Activity getActivity(Place place) {

      // TODO use GIN!
      if (place instanceof ManageProjectsPlace) {
         return this.manageProjectsActivityProvider.get().withPlace((ManageProjectsPlace)place);
      }
      if (place instanceof ViewProjectPlace) {
         return new ViewProjectActivity((ViewProjectPlace) place, clientFactory);
      }
      if (place instanceof EditProjectPlace) {
         return new EditProjectActivity((EditProjectPlace) place, clientFactory);
      }
      if (place instanceof AddProjectPlace) {
         return this.addProjectActivityProvider.get().withPlace((AddProjectPlace)place);
      }

      return null;
   }

}
