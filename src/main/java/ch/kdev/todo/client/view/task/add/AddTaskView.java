package ch.kdev.todo.client.view.task.add;

import ch.kdev.todo.client.view.base.BaseView;
import ch.kdev.todo.client.view.resources.ClientResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import eu.maydu.gwt.validation.client.ValidationProcessor;
import eu.maydu.gwt.validation.client.actions.LabelTextAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
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
   Button              addTaskButton;

   public AddTaskView() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @SuppressWarnings("unused")
   @Inject
   private void initializeValidator(ValidationProcessor validator) {
      this.validator = validator;
      this.validator.addValidators("name", new NotEmptyValidator(this.taskNameTextBox).addActionForFailure(new LabelTextAction(this.taskNameErrorLabel)).addActionForFailure(new StyleAction(this.getResources().css().validationFailedBorder())));
      this.validator.addValidators("description", new NotEmptyValidator(this.taskDescriptionTextArea).addActionForFailure(new LabelTextAction(this.taskDescriptionErrorLabel)).addActionForFailure(new StyleAction(this.getResources().css().validationFailedBorder())));
   }

   private ClientResources getResources() {
      ClientResources.instance.css().ensureInjected();

      return ClientResources.instance;
   }

   @Override
   public ValidationProcessor getValidator() {
      return this.validator;
   }

   @UiHandler("addTaskButton")
   void addTaskButtonClicked(ClickEvent e) {
      if (this.validator.validate()) {
         //String taskName = taskNameTextBox.getText();
         //String taskDescription = taskDescriptionTextArea.getText();

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
}
