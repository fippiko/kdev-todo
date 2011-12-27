package ch.kdev.todo.client.view.task.add;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;
import eu.maydu.gwt.validation.client.ValidationProcessor;

public interface IAddTaskView extends IBaseView {

   public interface Presenter extends IPresenter {
      void addNewTask();
   }

   public ValidationProcessor getValidator();

   public boolean hasChanges();

   public String getTaskName();
   public String getTaskDescription();
}
