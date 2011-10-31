package ch.kdev.todo.client.activity;

import ch.kdev.todo.client.AppMainFactory;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.view.ViewFactory;
import ch.kdev.todo.client.view.layout.AppLayout;
import ch.kdev.todo.client.view.mainmenu.MainMenuView;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MainActivity extends BaseActivity implements AppLayout.Presenter, MainMenuView.Presenter {

   //@Inject
   private ViewFactory viewFactory;

   @Inject
   public MainActivity(AppMainFactory mainFactory) {
      this.viewFactory = mainFactory.getViewFactory();
   }

   @Override
   public void gotoDefaultPlace() {
      this.gotoManageProjectsPlace();
   }

   @Override
   public void gotoManageProjectsPlace() {
      this.goTo(new ManageProjectsPlace());
   }

   @Override
   public AcceptsOneWidget getContentContainer() {
      return this.getAppLayout().getContentContainer();
   }

   @Override
   public Widget getMainLayoutPanel() {
      return this.getAppLayout().getMainLayoutPanel();
   }

   private AppLayout getAppLayout() {
      AppLayout appLayout = this.viewFactory.getAppLayout();
      appLayout.setPresenter(this);
      return appLayout;
   }

   @Override
   public MainMenuView getMainMenuView() {
      return this.viewFactory.getMainMenuView();
   }
}
