package ch.kdev.todo.client.activity.main;

import ch.kdev.todo.client.activity.base.BaseActivity;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.view.IBaseView;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.layout.IAppLayout;
import ch.kdev.todo.client.view.mainmenu.IMainMenuView;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MainActivity extends BaseActivity implements IAppLayout.Presenter, IMainMenuView.Presenter {

   @Inject
   private IViewFactory viewFactory;

   public MainActivity() {

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

   private IAppLayout getAppLayout() {
      IAppLayout appLayout = this.viewFactory.getClientLayout();
      appLayout.setPresenter(this);
      return appLayout;
   }

   @Override
   public IMainMenuView getMainMenuView() {
      return this.viewFactory.getMainMenuView();
   }

   @Override
   public IBaseView getView() {
      // the Main-Activity has more than one view
      return null;
   }
}
