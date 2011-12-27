package ch.kdev.todo.client.place.task;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AddTaskPlace extends Place {

   public static class Tokenizer implements PlaceTokenizer<AddTaskPlace> {

      @Override
      public AddTaskPlace getPlace(String token) {
         return new AddTaskPlace();
      }

      @Override
      public String getToken(AddTaskPlace place) {
         return "";
      }

   }
}
