package ch.kdev.todo.client.view.mainmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class MainMenuViewDesktop extends Composite implements MainMenuView {

   private Presenter presenter;

   interface MainMenuUiBinder extends UiBinder<HTMLPanel, MainMenuViewDesktop> {
   }

   private static MainMenuUiBinder binder = GWT.create(MainMenuUiBinder.class);

   @UiField
   Button                          manageProjectsButton;

   public MainMenuViewDesktop() {
      HTMLPanel panel = binder.createAndBindUi(this);
      initWidget(panel);
   }

   @UiHandler("manageProjectsButton")
   void manageProjectsButtonClicked(ClickEvent e) {
      presenter.gotoManageProjectsPlace();
   }

   @Override
   public void setPresenter(Presenter presenter) {
      this.presenter = presenter;
   }
}