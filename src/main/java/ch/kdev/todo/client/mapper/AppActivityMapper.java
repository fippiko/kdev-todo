package ch.kdev.todo.client.mapper;

import ch.kdev.todo.client.activity.ActivityFactory;
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
   private ActivityFactory activityFactory;

   /**
    * Map each Place to its corresponding Activity.
    */
   @Override
   public Activity getActivity(Place place) {

      if (place instanceof ManageProjectsPlace) {
         return this.activityFactory.getManageProjectsActivity().withPlace((ManageProjectsPlace) place);
      }
      if (place instanceof ViewProjectPlace) {
         return this.activityFactory.getViewProjectActivity().withPlace((ViewProjectPlace) place);
      }
      if (place instanceof EditProjectPlace) {
         return this.activityFactory.getEditProjectActivity().withPlace((EditProjectPlace) place);
      }
      if (place instanceof AddProjectPlace) {
         return this.activityFactory.getAddProjectActivity().withPlace((AddProjectPlace) place);
      }

      return null;
   }

}
