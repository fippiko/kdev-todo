package ch.kdev.todo.client.place.project;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EditProjectPlace extends Place {
   private String projectId;

   public EditProjectPlace(String projectId) {
      this.projectId = projectId;
   }

   public String getProjectID() {
      return projectId;
   }

   public static class Tokenizer implements PlaceTokenizer<EditProjectPlace> {
      @Override
      public String getToken(EditProjectPlace place) {
         return place.getProjectID();
      }

      @Override
      public EditProjectPlace getPlace(String token) {
         return new EditProjectPlace(token);
      }

   }
}
