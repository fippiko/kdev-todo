package ch.kdev.todo.client.view.mainmenu;

import ch.kdev.todo.client.view.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class MainMenuView extends BaseView<IMainMenuView.Presenter> implements IMainMenuView {

   interface MainMenuUiBinder extends UiBinder<HTMLPanel, MainMenuView> {
   }

   private static MainMenuUiBinder binder = GWT.create(MainMenuUiBinder.class);

   @UiField
   Tree                            tree;

   public MainMenuView() {
      initWidget(binder.createAndBindUi(this));
   }

   @UiHandler("tree")
   public void onSelection(SelectionEvent<TreeItem> event) {
      String selectedItemText = event.getSelectedItem().getText();

      if (selectedItemText.equals(this.getConstants().addTask())) {
         this.getPresenter().gotoAddTask();
      }
      else if (selectedItemText.equals(this.getConstants().manageProjects())) {
         this.getPresenter().gotoManageProjectsPlace();
      }
   }
}