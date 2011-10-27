package ch.kdev.todo.client.view.project.add;

import ch.kdev.todo.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AddProjectViewDesktop extends BaseView<AddProjectView.Presenter> implements AddProjectView {
   private static AddProjectDesktopUiBinder uiBinder = GWT.create(AddProjectDesktopUiBinder.class);

   interface AddProjectDesktopUiBinder extends UiBinder<Widget, AddProjectViewDesktop> {
   }

   @UiField
   TextBox  projectNameTextBox;

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

      this.validateForm();

      this.getPresenter().addNewProject(projectName, projectDescription);
   }

   private void validateForm() {
      // TODO Auto-generated method stub

   }
}
