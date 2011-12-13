package ch.kdev.todo.client.view.project.add;

import ch.kdev.todo.client.activity.BasePresenterInterface;
import ch.kdev.todo.client.view.BaseViewInterface;
import eu.maydu.gwt.validation.client.ValidationProcessor;

public interface AddProjectView extends BaseViewInterface {

   public interface Presenter extends BasePresenterInterface {
      void addNewProject(String projectName, String projectDescription);
   }
   
   public ValidationProcessor getValidator();
}
