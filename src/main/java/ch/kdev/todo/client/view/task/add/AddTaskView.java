package ch.kdev.todo.client.view.task.add;

import ch.kdev.todo.client.view.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import eu.maydu.gwt.validation.client.ValidationProcessor;
import eu.maydu.gwt.validation.client.actions.LabelTextAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.validators.ListBoxValidator;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class AddTaskView extends BaseView<IAddTaskView.Presenter> implements IAddTaskView {
   private static AddTaskUiBinder uiBinder = GWT.create(AddTaskUiBinder.class);

   interface AddTaskUiBinder extends UiBinder<Widget, AddTaskView> {
   }

   ValidationProcessor validator;

   @UiField
   TextBox             taskNameTextBox;

   @UiField
   Label               taskNameErrorLabel;

   @UiField
   TextArea            taskDescriptionTextArea;

   @UiField
   Label               taskDescriptionErrorLabel;

   @UiField
   ListBox             projectListBox;

   @UiField
   Label               projectListBoxErrorLabel;

   @UiField
   Button              addTaskButton;

   public AddTaskView() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @Override
   protected void onLoad() {
      super.onLoad();

      initializeValidator();
      this.getPresenter().initProjectList();
   }

   private void initializeValidator() {
      this.validator = this.getViewFactory().getValidator();

      this.validator.addValidators("name", new NotEmptyValidator(this.taskNameTextBox).addActionForFailure(new LabelTextAction(this.taskNameErrorLabel)).addActionForFailure(new StyleAction(this.getCssResource().validationFailedBorder())));
      this.validator.addValidators("description", new NotEmptyValidator(this.taskDescriptionTextArea).addActionForFailure(new LabelTextAction(this.taskDescriptionErrorLabel)).addActionForFailure(new StyleAction(this.getCssResource().validationFailedBorder())));
      this.validator.addValidators("projectId", new ListBoxValidator(this.projectListBox).addActionForFailure(new LabelTextAction(this.projectListBoxErrorLabel)).addActionForFailure(new StyleAction(this.getCssResource().validationFailedBorder())));
   }

   @Override
   public ValidationProcessor getValidator() {
      return this.validator;
   }

   @UiHandler("addTaskButton")
   void addTaskButtonClicked(ClickEvent e) {
      if (this.validator.validate()) {
         this.getPresenter().addNewTask();
      }
   }

   @Override
   public boolean hasChanges() {
      boolean hasChanges = false;

      if (taskNameTextBox.getText().length() > 0) {
         hasChanges = true;
      }
      if (taskDescriptionTextArea.getText().length() > 0) {
         hasChanges = true;
      }

      return hasChanges;
   }

   @Override
   public String getTaskName() {
      return this.taskNameTextBox.getText();
   }

   @Override
   public String getTaskDescription() {
      return this.taskDescriptionTextArea.getText();
   }

   @Override
   public Long getProjectId() {
      int selectedIndex = this.projectListBox.getSelectedIndex();
      String selectedValue = this.projectListBox.getValue(selectedIndex);
      return Long.parseLong(selectedValue);
   }

   @Override
   public void addProject(String name, String id) {
      this.projectListBox.addItem(name, id);
   }
}
