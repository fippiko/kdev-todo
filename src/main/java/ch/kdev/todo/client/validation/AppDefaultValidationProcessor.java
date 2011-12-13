package ch.kdev.todo.client.validation;

import eu.maydu.gwt.validation.client.DefaultValidationProcessor;
import eu.maydu.gwt.validation.client.ValidationException;

public class AppDefaultValidationProcessor extends DefaultValidationProcessor implements AppValidationProcessor {

   @Override
   public boolean processConstraintViolations(ValidationException validationException) {
      // TODO Auto-generated method stub
      return false;

   }
}
