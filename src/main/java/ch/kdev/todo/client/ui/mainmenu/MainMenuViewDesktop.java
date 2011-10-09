package ch.kdev.todo.client.ui.mainmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;

public class MainMenuViewDesktop extends Composite implements MainMenuView {
   private Presenter presenter;

   interface MainMenuUiBinder extends UiBinder<HTMLPanel, MainMenuViewDesktop> {
   }

   private static MainMenuUiBinder binder = GWT.create(MainMenuUiBinder.class);

   @UiField
   Button                          manageProjectsButton;

   @Inject
   public MainMenuViewDesktop(Presenter presenter) {
      this.presenter = presenter;

      HTMLPanel panel = binder.createAndBindUi(this);
      initWidget(panel);
   }

   @UiHandler("manageProjectsButton")
   void manageProjectsButtonClicked(ClickEvent e) {
      presenter.gotoManageProjectsPlace();
   }
}