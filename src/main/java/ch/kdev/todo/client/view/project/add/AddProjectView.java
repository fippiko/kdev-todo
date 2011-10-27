package ch.kdev.todo.client.view.project.add;

import ch.kdev.todo.client.activity.BasePresenterInterface;
import ch.kdev.todo.client.view.BaseViewInterface;

public interface AddProjectView extends BaseViewInterface {

   public interface Presenter extends BasePresenterInterface {
      void addNewProject(String projectName, String projectDescription);
   }
}
