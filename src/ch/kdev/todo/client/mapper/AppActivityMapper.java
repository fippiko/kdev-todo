package ch.kdev.todo.client.mapper;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.activity.project.AddProjectActivity;
import ch.kdev.todo.client.activity.project.EditProjectActivity;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

   private ClientFactory clientFactory;

   /**
    * AppActivityMapper associates each Place with its corresponding
    * {@link Activity}
    * 
    * @param clientFactory
    *        Factory to be passed to activities
    */
   public AppActivityMapper(ClientFactory clientFactory) {
      super();
      this.clientFactory = clientFactory;
   }

   /**
    * Map each Place to its corresponding Activity.
    */
   @Override
   public Activity getActivity(Place place) {

      // TODO use GIN!
      if (place instanceof ManageProjectsPlace) {
         return new ManageProjectsActivity((ManageProjectsPlace) place, clientFactory);
      }
      if (place instanceof EditProjectPlace) {
         return new EditProjectActivity((EditProjectPlace) place, clientFactory);
      }
      if (place instanceof AddProjectPlace) {
         return new AddProjectActivity((AddProjectPlace) place, clientFactory);
      }

      return null;
   }

}