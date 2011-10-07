package ch.kdev.todo.client.place.project;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AddProjectPlace extends Place {

   public static class Tokenizer implements PlaceTokenizer<AddProjectPlace> {

      @Override
      public AddProjectPlace getPlace(String token) {
         return new AddProjectPlace();
      }

      @Override
      public String getToken(AddProjectPlace place) {
         return "";
      }

   }
}
