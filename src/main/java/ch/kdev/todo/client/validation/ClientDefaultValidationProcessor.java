package ch.kdev.todo.client.validation;

import eu.maydu.gwt.validation.client.DefaultValidationProcessor;
import eu.maydu.gwt.validation.client.ValidationException;

public class ClientDefaultValidationProcessor extends DefaultValidationProcessor implements ClientValidationProcessor {

   @Override
   public boolean processConstraintViolations(ValidationException validationException) {
      // TODO Auto-generated method stub
      return false;

   }
}
