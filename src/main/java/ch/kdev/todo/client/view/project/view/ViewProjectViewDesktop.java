package ch.kdev.todo.client.view.project.view;

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

public class ViewProjectViewDesktop extends BaseView<ViewProjectView.Presenter> implements ViewProjectView {
   private static EditProjectDesktopUiBinder uiBinder = GWT.create(EditProjectDesktopUiBinder.class);

   interface EditProjectDesktopUiBinder extends UiBinder<Widget, ViewProjectViewDesktop> {
   }

   @UiField
   TextBox  projectNameTextBox;

   @UiField
   TextArea projectDescriptionTextArea;

   @UiField
   Button   editProjectButton;

   public ViewProjectViewDesktop() {
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

   @Override
   public void setProjectAttributes(ProjectProxy project) {
      this.projectNameTextBox.setText(project.getName());
      this.projectDescriptionTextArea.setText(project.getDescription());
   }

}
