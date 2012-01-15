package ch.kdev.todo.client.view.project.view;

import ch.kdev.todo.client.view.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ViewProjectView extends BaseView<IViewProjectView.Presenter> implements IViewProjectView {
   private static ViewProjectDesktopUiBinder uiBinder = GWT.create(ViewProjectDesktopUiBinder.class);

   interface ViewProjectDesktopUiBinder extends UiBinder<Widget, ViewProjectView> {
   }

   @UiField
   TextBox  projectNameTextBox;

   @UiField
   TextArea projectDescriptionTextArea;

   @UiField
   ListBox  taskList;

   public ViewProjectView() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @UiHandler("editProjectButton")
   public void updateProjectButtonClicked(ClickEvent e) {
      this.getPresenter().editProject();
   }

   @UiHandler("manageProjectsButton")
   void manageProjectsButtonClicked(ClickEvent e) {
      this.getPresenter().manageProjects();
   }
   
   @UiHandler("addTaskButton")
   void addTaskButtonClicked(ClickEvent e) {
      this.getPresenter().addTask();
   }
   
   @UiHandler("removeTaskButton")
   void removeTaskButtonClicked(ClickEvent e) {
      this.getPresenter().removeTask();
   }

   @Override
   public void setProjectName(String name) {
      this.projectNameTextBox.setText(name);
   }

   @Override
   public void setProjectDescription(String description) {
      this.projectDescriptionTextArea.setText(description);
   }

   @Override
   public void addTaskListItem(String taskName, String taskId) {
      this.taskList.addItem(taskName, taskId);
   }

   @Override
   public String getSelectedTaskListValue() {
      return this.taskList.getValue(this.taskList.getSelectedIndex());
   }

   @Override
   public void removeTaskListItem(Long itemValue) {
      String itemValueString = String.valueOf(itemValue);
      for(int itemIndex = 0; itemIndex < this.taskList.getItemCount(); itemIndex++){
         if(this.taskList.getValue(itemIndex).equals(itemValueString)){
            this.taskList.removeItem(itemIndex);
            break;
         }
      }
   }
}
