package ch.kdev.todo.client.view.task.add;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;
import eu.maydu.gwt.validation.client.ValidationProcessor;

public interface IAddTaskView extends IBaseView {

   public interface Presenter extends IPresenter {
      void addNewTask();

      void initProjectList();
   }

   public ValidationProcessor getValidator();

   public boolean hasChanges();

   public String getTaskName();
   public String getTaskDescription();
   public Long getProjectId();

   // public void initProjectList(List<ProjectProxy> response);
   public void addProject(String name, String id);
}
