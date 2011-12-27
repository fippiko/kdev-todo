package ch.kdev.todo.client.view.project.add;

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

public class AddProjectView extends BaseView<IAddProjectView.Presenter> implements IAddProjectView {
   private static AddProjectUiBinder uiBinder = GWT.create(AddProjectUiBinder.class);

   interface AddProjectUiBinder extends UiBinder<Widget, AddProjectView> {
   }

   ValidationProcessor validator;

   @UiField
   TextBox             projectNameTextBox;

   @UiField
   Label               projectNameErrorLabel;

   @UiField
   TextArea            projectDescriptionTextArea;

   @UiField
   Label               projectDescriptionErrorLabel;

   @UiField
   Button              addProjectButton;

   public AddProjectView() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @SuppressWarnings("unused")
   @Inject
   private void initializeValidator(ValidationProcessor validator) {
      this.validator = validator;
      this.validator.addValidators("name", new NotEmptyValidator(this.projectNameTextBox).addActionForFailure(new LabelTextAction(this.projectNameErrorLabel)).addActionForFailure(new StyleAction(this.getResources().css().validationFailedBorder())));
      this.validator.addValidators("description", new NotEmptyValidator(this.projectDescriptionTextArea).addActionForFailure(new LabelTextAction(this.projectDescriptionErrorLabel)).addActionForFailure(new StyleAction(this.getResources().css().validationFailedBorder())));
   }

   private ClientResources getResources() {
      ClientResources.instance.css().ensureInjected();

      return ClientResources.instance;
   }

   @Override
   public ValidationProcessor getValidator() {
      return this.validator;
   }

   @UiHandler("addProjectButton")
   void addProjectButtonClicked(ClickEvent e) {
      if (this.validator.validate()) {
         //String projectName = projectNameTextBox.getText();
         //String projectDescription = projectDescriptionTextArea.getText();

         //this.getPresenter().addNewProject(projectName, projectDescription);
         this.getPresenter().addNewProject();
      }
   }

   @Override
   public boolean hasChanges() {
      boolean hasChanges = false;

      if (projectNameTextBox.getText().length() > 0) {
         hasChanges = true;
      }
      if (projectDescriptionTextArea.getText().length() > 0) {
         hasChanges = true;
      }

      return hasChanges;
   }

   @Override
   public String getProjectName() {
      return this.projectNameTextBox.getText();
   }

   @Override
   public String getProjectDescription() {
      return this.projectDescriptionTextArea.getText();
   }
}
