package ch.kdev.todo.client.ui.project.manage;

import java.util.List;

import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class ManageProjectsViewDesktop extends Composite implements ManageProjectsView {
   private static ManageProjectsDesktopUiBinder uiBinder = GWT.create(ManageProjectsDesktopUiBinder.class);

   interface ManageProjectsDesktopUiBinder extends UiBinder<Widget, ManageProjectsViewDesktop> {
   }

   private Presenter presenter;

   @UiField
   ListBox           projectList;

   @UiField
   Button            editProjectButton;

   @UiField
   Button            addProjectButton;

   public ManageProjectsViewDesktop() {
      initWidget(uiBinder.createAndBindUi(this));
   }

   @Override
   protected void onLoad() {
      super.onLoad();

      this.enableWidgets();

      this.reloadProjectList();
   }

   private void enableWidgets() {
      Boolean itemSelected = projectList.getSelectedIndex() >= 0;

      editProjectButton.setEnabled(itemSelected);
   }

   private void reloadProjectList() {
      presenter.reloadProjectList();
   }

   @Override
   public void setPresenter(Presenter presenter) {
      this.presenter = presenter;
   }

   @UiHandler("editProjectButton")
   void editProjectButtonClicked(ClickEvent e) {
      String selectedProject = projectList.getValue(projectList.getSelectedIndex());
      presenter.goTo(new EditProjectPlace(selectedProject));
   }

   @UiHandler("addProjectButton")
   void addProjectButtonClicked(ClickEvent e) {
      presenter.goTo(new AddProjectPlace());
   }

   @UiHandler("projectList")
   void projectListSelectionChanged(ChangeEvent e) {
      enableWidgets();
   }

   @Override
   public void updateProjectList(List<ProjectProxy> projects) {
      projectList.clear();
      for (ProjectProxy project : projects) {
         projectList.addItem(project.getName() + " : " + project.getDescription(), String.valueOf(project.getID()));
      }
   }
}
