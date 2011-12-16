package ch.kdev.todo.client.view.project.add;

import ch.kdev.todo.client.activity.base.IBaseActivity;
import ch.kdev.todo.client.view.IBaseView;
import eu.maydu.gwt.validation.client.ValidationProcessor;

public interface IAddProjectView extends IBaseView {

   public interface Presenter extends IBaseActivity {
      void addNewProject(String projectName, String projectDescription);
   }

   public ValidationProcessor getValidator();

   public void showError(String errorMessage);

   public boolean hasChanges();
}
