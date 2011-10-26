package ch.kdev.todo.client.ui.project.view;

import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ViewProjectViewDesktop extends Composite implements ViewProjectView {
   private static EditProjectDesktopUiBinder uiBinder = GWT.create(EditProjectDesktopUiBinder.class);

   interface EditProjectDesktopUiBinder extends UiBinder<Widget, ViewProjectViewDesktop> {
   }

   private Presenter presenter;

   @UiField
   TextBox           projectNameTextBox;

   @UiField
   TextArea          projectDescriptionTextArea;

   @UiField
   Button            editProjectButton;

   public ViewProjectViewDesktop() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @Override
   public void setPresenter(Presenter presenter) {
      this.presenter = presenter;
   }

   @UiHandler("editProjectButton")
   public void updateProjectButtonClicked(ClickEvent e) {
      this.presenter.editProject();
   }

   @UiHandler("manageProjectsButton")
   void manageProjectsButtonClicked(ClickEvent e) {
      this.presenter.manageProjects();
   }

   @Override
   public void setProjectAttributes(ProjectProxy project) {
      this.projectNameTextBox.setText(project.getName());
      this.projectDescriptionTextArea.setText(project.getDescription());
   }

}
