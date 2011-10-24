package ch.kdev.todo.client.place.project;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ViewProjectPlace extends Place {
   private String projectId;

   public ViewProjectPlace(String projectId) {
      this.projectId = projectId;
   }

   public String getProjectID() {
      return projectId;
   }

   public static class Tokenizer implements PlaceTokenizer<ViewProjectPlace> {
      @Override
      public String getToken(ViewProjectPlace place) {
         return place.getProjectID();
      }

      @Override
      public ViewProjectPlace getPlace(String token) {
         return new ViewProjectPlace(token);
      }

   }
}
