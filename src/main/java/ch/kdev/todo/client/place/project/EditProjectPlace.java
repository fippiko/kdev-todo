package ch.kdev.todo.client.place.project;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EditProjectPlace extends Place {
   private Long projectId;

   public EditProjectPlace(Long projectId) {
      this.projectId = projectId;
   }

   public Long getProjectId() {
      return projectId;
   }

   public static class Tokenizer implements PlaceTokenizer<EditProjectPlace> {
      @Override
      public String getToken(EditProjectPlace place) {
         return place.getProjectId().toString();
      }

      @Override
      public EditProjectPlace getPlace(String token) {
         Long projectId = Long.parseLong(token);
         return new EditProjectPlace(projectId);
      }

   }
}
