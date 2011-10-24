package ch.kdev.todo.client;

import ch.kdev.todo.client.ui.layout.AppLayout;
import ch.kdev.todo.client.ui.layout.AppLayoutDesktop;
import ch.kdev.todo.client.ui.mainmenu.MainMenuView;
import ch.kdev.todo.client.ui.mainmenu.MainMenuViewDesktop;
import ch.kdev.todo.client.ui.project.add.AddProjectView;
import ch.kdev.todo.client.ui.project.add.AddProjectViewDesktop;
import ch.kdev.todo.client.ui.project.edit.EditProjectView;
import ch.kdev.todo.client.ui.project.edit.EditProjectViewDesktop;
import ch.kdev.todo.client.ui.project.manage.ManageProjectsView;
import ch.kdev.todo.client.ui.project.manage.ManageProjectsViewDesktop;
import ch.kdev.todo.client.ui.project.view.ViewProjectView;
import ch.kdev.todo.client.ui.project.view.ViewProjectViewDesktop;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryDesktopModule extends AbstractGinModule {

   @Override
   protected void configure() {
      // bind(AppPresenter.class).in(Singleton.class);
      bind(ClientFactory.class).to(ClientFactoryDesktop.class).in(Singleton.class);

      bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
      bind(PlaceController.class).to(SimplePlaceController.class).in(Singleton.class);
      bind(AppRequestFactory.class).in(Singleton.class);

      bind(AppLayout.class).to(AppLayoutDesktop.class).in(Singleton.class);
      bind(AppLayout.Presenter.class).to(AppPresenter.class);
      bind(MainMenuView.class).to(MainMenuViewDesktop.class).in(Singleton.class);
      bind(MainMenuView.Presenter.class).to(AppPresenter.class);

      bind(ManageProjectsView.class).to(ManageProjectsViewDesktop.class).in(Singleton.class);
      bind(ViewProjectView.class).to(ViewProjectViewDesktop.class);
      bind(AddProjectView.class).to(AddProjectViewDesktop.class);
      bind(EditProjectView.class).to(EditProjectViewDesktop.class);
   }
}
