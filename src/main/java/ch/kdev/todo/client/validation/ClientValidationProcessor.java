package ch.kdev.todo.client.validation;

import eu.maydu.gwt.validation.client.ValidationException;
import eu.maydu.gwt.validation.client.ValidationProcessor;

public interface ClientValidationProcessor extends ValidationProcessor {
   public boolean processConstraintViolations(ValidationException validationException);
}
