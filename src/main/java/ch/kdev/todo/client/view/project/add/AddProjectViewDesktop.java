package ch.kdev.todo.client.view.project.add;

import ch.kdev.todo.client.AppMainFactory;
import ch.kdev.todo.client.view.BaseView;
import ch.kdev.todo.client.view.resources.AppResourcesDesktop;
import ch.kdev.todo.client.view.widgets.messagebox.error.ErrorMessageBoxDesktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.CssResource;
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

public class AddProjectViewDesktop extends BaseView<AddProjectView.Presenter> implements AddProjectView {
   private static AddProjectDesktopUiBinder uiBinder = GWT.create(AddProjectDesktopUiBinder.class);

   interface AddProjectDesktopUiBinder extends UiBinder<Widget, AddProjectViewDesktop> {
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

   public AddProjectViewDesktop() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @Inject
   private void initializeValidator(ValidationProcessor validator) {
      this.validator = validator;
      this.validator.addValidators("name", new NotEmptyValidator(this.projectNameTextBox).addActionForFailure(new LabelTextAction(this.projectNameErrorLabel)).addActionForFailure(new StyleAction(this.getResources().css().validationFailedBorder())));
      this.validator.addValidators("description", new NotEmptyValidator(this.projectDescriptionTextArea).addActionForFailure(new LabelTextAction(this.projectDescriptionErrorLabel)).addActionForFailure(new StyleAction(this.getResources().css().validationFailedBorder())));
   }

   private AppResourcesDesktop getResources(){
      AppResourcesDesktop.instance.css().ensureInjected();
      
      return AppResourcesDesktop.instance;
   }
   
   @Override
   public ValidationProcessor getValidator() {
      return this.validator;
   }

   @UiHandler("addProjectButton")
   void addProjectButtonClicked(ClickEvent e) {
      ErrorMessageBoxDesktop test = new ErrorMessageBoxDesktop();
      test.show();
      
      if (this.validator.validate()) {
         String projectName = projectNameTextBox.getText();
         String projectDescription = projectDescriptionTextArea.getText();

         this.getPresenter().addNewProject(projectName, projectDescription);
      }
   }
}
