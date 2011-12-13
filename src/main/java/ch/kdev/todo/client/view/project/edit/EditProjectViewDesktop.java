package ch.kdev.todo.client.view.project.edit;

import ch.kdev.todo.client.view.BaseView;
import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditProjectViewDesktop extends BaseView<EditProjectView.Presenter> implements EditProjectView {
   private static EditProjectDesktopUiBinder uiBinder = GWT.create(EditProjectDesktopUiBinder.class);

   interface EditProjectDesktopUiBinder extends UiBinder<Widget, EditProjectViewDesktop> { }

   @UiField
   TextBox  projectNameTextBox;

   @UiField
   TextArea projectDescriptionTextArea;

   @UiField
   Button   updateProjectButton;

   public EditProjectViewDesktop() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @Override
   public void setProjectAttributes(ProjectProxy project) {
      this.projectNameTextBox.setText(project.getName());
      this.projectDescriptionTextArea.setText(project.getDescription());
   }

   @UiHandler("updateProjectButton")
   public void updateProjectButtonClicked(ClickEvent e) {
      this.getPresenter().saveProject();
   }

   @Override
   public ProjectProxy getProjectAttributes(ProjectProxy editableProject) {
      editableProject.setName(this.projectNameTextBox.getText());
      editableProject.setDescription(this.projectDescriptionTextArea.getText());

      return editableProject;
   }

}
