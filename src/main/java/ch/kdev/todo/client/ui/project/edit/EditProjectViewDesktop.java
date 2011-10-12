package ch.kdev.todo.client.ui.project.edit;

import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditProjectViewDesktop extends Composite implements EditProjectView {
   private static EditProjectDesktopUiBinder uiBinder = GWT.create(EditProjectDesktopUiBinder.class);

   interface EditProjectDesktopUiBinder extends UiBinder<Widget, EditProjectViewDesktop> {
   }

   @SuppressWarnings("unused")
   private Presenter presenter;
   
   @UiField
   TextBox           projectNameTextBox;

   @UiField
   TextArea          projectDescriptionTextArea;
   
   @UiField
   Button            updateProjectButton;

   public EditProjectViewDesktop() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @Override
   public void setPresenter(Presenter presenter) {
      this.presenter = presenter;
   }

   @Override
   public void setProject(ProjectProxy project) {
      projectNameTextBox.setText(project.getName());
      projectDescriptionTextArea.setText(project.getDescription());
   }
}
