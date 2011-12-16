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

public class ViewProjectView extends BaseView<IViewProjectView.Presenter> implements IViewProjectView {
   private static ViewProjectDesktopUiBinder uiBinder = GWT.create(ViewProjectDesktopUiBinder.class);

   interface ViewProjectDesktopUiBinder extends UiBinder<Widget, ViewProjectView> {
   }

   @UiField
   TextBox  projectNameTextBox;

   @UiField
   TextArea projectDescriptionTextArea;

   @UiField
   Button   editProjectButton;

   public ViewProjectView() {
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
