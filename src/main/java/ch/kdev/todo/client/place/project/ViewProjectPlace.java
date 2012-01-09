package ch.kdev.todo.client.place.project;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ViewProjectPlace extends Place {
   private Long projectId;

   public ViewProjectPlace(Long projectId) {
      this.projectId = projectId;
   }

   public Long getProjectId() {
      return projectId;
   }

   public static class Tokenizer implements PlaceTokenizer<ViewProjectPlace> {
      @Override
      public String getToken(ViewProjectPlace place) {
         return place.getProjectId().toString();

      }

      @Override
      public ViewProjectPlace getPlace(String token) {
         Long projectId = Long.parseLong(token);
         return new ViewProjectPlace(projectId);
      }

   }
}
