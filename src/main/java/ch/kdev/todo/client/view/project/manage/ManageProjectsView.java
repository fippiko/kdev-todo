package ch.kdev.todo.client.view.project.manage;

import java.util.List;

import ch.kdev.todo.client.view.base.BaseView;
import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class ManageProjectsView extends BaseView<IManageProjectsView.Presenter> implements IManageProjectsView {
   private static ManageProjectsDesktopUiBinder uiBinder = GWT.create(ManageProjectsDesktopUiBinder.class);

   interface ManageProjectsDesktopUiBinder extends UiBinder<Widget, ManageProjectsView> {
   }

   @UiField
   ListBox   projectList;

   @UiField
   Button    viewProjectButton;

   @UiField
   Button    editProjectButton;

   @UiField
   Button    addProjectButton;

   @UiField
   Button    deleteProjectButton;

   @UiField
   FlowPanel subViewPanel;

   public ManageProjectsView() {
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

      viewProjectButton.setEnabled(itemSelected);
      editProjectButton.setEnabled(itemSelected);
      deleteProjectButton.setEnabled(itemSelected);
   }

   private void reloadProjectList() {
      this.getPresenter().reloadProjectList();
   }

   @UiHandler("viewProjectButton")
   void viewProjectButtonClicked(ClickEvent e) {
      this.getPresenter().viewSelectedProject();
   }

   @UiHandler("editProjectButton")
   void editProjectButtonClicked(ClickEvent e) {
      this.getPresenter().editSelectedProject();
   }

   @UiHandler("deleteProjectButton")
   void deleteProjectButtonClicked(ClickEvent e) {
      this.getPresenter().deleteSelectedProject();
   }

   @UiHandler("addProjectButton")
   void addProjectButtonClicked(ClickEvent e) {
      this.getPresenter().addNewProject();
   }

   @UiHandler("projectList")
   void projectListSelectionChanged(ChangeEvent e) {
      enableWidgets();
   }

   @Override
   public void updateProjectList(List<ProjectProxy> projects) {
      projectList.clear();
      for (ProjectProxy project : projects) {
         projectList.addItem(project.getName() + " : " + project.getDescription(), String.valueOf(project.getId()));
      }

      this.enableWidgets();
   }

   @Override
   public String getSelectedProjectId() {
      String selectedProjectId = projectList.getValue(projectList.getSelectedIndex());
      return selectedProjectId;
   }
}
