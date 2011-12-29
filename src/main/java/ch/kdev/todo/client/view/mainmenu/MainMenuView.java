package ch.kdev.todo.client.view.mainmenu;

import ch.kdev.todo.client.view.base.BaseView;
import ch.kdev.todo.client.view.resources.ClientMessages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;

public class MainMenuView extends BaseView<IMainMenuView.Presenter> implements IMainMenuView {

   interface MainMenuUiBinder extends UiBinder<HTMLPanel, MainMenuView> {
   }

   private static MainMenuUiBinder binder = GWT.create(MainMenuUiBinder.class);
   
   @UiField Tree tree;

   public MainMenuView() {
      initWidget(binder.createAndBindUi(this));
   }
   
   @UiHandler("tree")
   public void onSelection(SelectionEvent<TreeItem> event) {
      String selectedItemText = event.getSelectedItem().getText();
      
      ClientMessages messages = this.getViewFactory().getClientMessages();
      
      if(selectedItemText.equals("New Task")){
         this.getPresenter().gotoAddTask();
      }
      else if(selectedItemText.equals(messages.manageProjects())){
         this.getPresenter().gotoManageProjectsPlace();
      }
   }
}