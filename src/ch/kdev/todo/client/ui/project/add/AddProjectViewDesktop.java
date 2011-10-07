package ch.kdev.todo.client.ui.project.add;

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

public class AddProjectViewDesktop extends Composite implements AddProjectView {
   private static AddProjectDesktopUiBinder uiBinder = GWT.create(AddProjectDesktopUiBinder.class);

   interface AddProjectDesktopUiBinder extends UiBinder<Widget, AddProjectViewDesktop> {
   }

   private Presenter presenter;

   @UiField
   TextBox           projectNameTextBox;

   @UiField
   TextArea          projectDescriptionTextArea;

   @UiField
   Button            addProjectButton;

   public AddProjectViewDesktop() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @Override
   public void setPresenter(Presenter presenter) {
      this.presenter = presenter;
   }

   @UiHandler("addProjectButton")
   void addProjectButtonClicked(ClickEvent e) {
      String projectName = projectNameTextBox.getText();
      String projectDescription = projectDescriptionTextArea.getText();
      
      //TODO validate here
      
      presenter.addNewProject(projectName, projectDescription);
   }
}
