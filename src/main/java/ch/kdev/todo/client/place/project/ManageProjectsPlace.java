package ch.kdev.todo.client.place.project;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ManageProjectsPlace extends Place {

   public ManageProjectsPlace() {
      // TODO create place by token
   }

   public static class Tokenizer implements PlaceTokenizer<ManageProjectsPlace> {
      @Override
      public String getToken(ManageProjectsPlace place) {
         return "";
         // TODO return token
      }

      @Override
      public ManageProjectsPlace getPlace(String token) {
         return new ManageProjectsPlace();
      }

   }
}
