package ch.kdev.todo.client.view.project.add;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;
import eu.maydu.gwt.validation.client.ValidationProcessor;

public interface IAddProjectView extends IBaseView {

   public interface Presenter extends IPresenter {
      // void addNewProject(String projectName, String projectDescription);
      void addNewProject();
   }

   public String getProjectName();
   public String getProjectDescription();

   public ValidationProcessor getValidator();

   public boolean hasChanges();
}
