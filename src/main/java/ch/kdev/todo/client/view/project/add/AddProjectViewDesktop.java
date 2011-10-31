package ch.kdev.todo.client.view.project.add;

import ch.kdev.todo.client.view.BaseView;

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

public class AddProjectViewDesktop extends BaseView<AddProjectView.Presenter> implements AddProjectView {
   private static AddProjectDesktopUiBinder uiBinder = GWT.create(AddProjectDesktopUiBinder.class);

   interface AddProjectDesktopUiBinder extends UiBinder<Widget, AddProjectViewDesktop> {
   }

   @Inject
   ValidationProcessor validator;
   
   @UiField
   TextBox  projectNameTextBox;
   
   @UiField
   Label projectNameErrorLabel;

   @UiField
   TextArea projectDescriptionTextArea;

   @UiField
   Button   addProjectButton;

   public AddProjectViewDesktop() {           
      initWidget(uiBinder.createAndBindUi(this));
   }
   

   @UiHandler("addProjectButton")
   void addProjectButtonClicked(ClickEvent e) {
      String projectName = projectNameTextBox.getText();
      String projectDescription = projectDescriptionTextArea.getText();

      this.getPresenter().addNewProject(projectName, projectDescription);
   }
}
