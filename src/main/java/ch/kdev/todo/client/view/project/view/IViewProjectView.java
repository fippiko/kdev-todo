package ch.kdev.todo.client.view.project.view;

import ch.kdev.todo.client.view.base.IBaseView;
import ch.kdev.todo.client.view.base.IPresenter;

public interface IViewProjectView extends IBaseView {

   public interface Presenter extends IPresenter {
      void manageProjects();

      void editProject();

      void addTask();
      void removeTask();
   }

   void setProjectName(String name);
   void setProjectDescription(String description);
   void addTaskListItem(String taskId, String taskName);
   void removeTaskListItem(Long selectedTaskId);
   String getSelectedTaskListValue();
   
}
