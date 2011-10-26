package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.provider.ManageProjectsActivityProvider;
import ch.kdev.todo.client.mapper.AppActivityManager;
import ch.kdev.todo.client.mapper.AppActivityMapper;
import ch.kdev.todo.client.mapper.AppPlaceHistoryHandler;
import ch.kdev.todo.client.mapper.AppPlaceHistoryMapper;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
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

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public class ClientFactoryDesktopModule extends AbstractGinModule {

   @Override
   protected void configure() {
      bind(ClientFactory.class).to(ClientFactoryDesktop.class).in(Singleton.class);
      
      // Application Mapping
      bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);
      bind(ActivityManager.class).to(AppActivityManager.class).in(Singleton.class);
      
      bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);
      bind(PlaceHistoryHandler.class).to(AppPlaceHistoryHandler.class).in(Singleton.class);
      bind(Place.class).to(ManageProjectsPlace.class); //needed because of the use of a default-place in the constructor of AppPlaceHistoryHandler

      bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
      bind(PlaceController.class).to(SimplePlaceController.class).in(Singleton.class);
      bind(AppRequestFactory.class).in(Singleton.class);

      // Layout Mapping
      bind(AppLayout.class).to(AppLayoutDesktop.class).in(Singleton.class);
      bind(AppLayout.Presenter.class).to(AppPresenter.class);
      bind(MainMenuView.class).to(MainMenuViewDesktop.class).in(Singleton.class);
      bind(MainMenuView.Presenter.class).to(AppPresenter.class);

      bind(ManageProjectsView.class).to(ManageProjectsViewDesktop.class).in(Singleton.class);
      bind(ViewProjectView.class).to(ViewProjectViewDesktop.class);
      bind(AddProjectView.class).to(AddProjectViewDesktop.class);
      bind(EditProjectView.class).to(EditProjectViewDesktop.class);
      
      bind(ManageProjectsActivityProvider.class).in(Singleton.class);
   }
   /*
   @Provides
   @Singleton
   @Inject
   public RequestFactory createAppRequestFactory(EventBus eventBus){
      AppRequestFactory requestFactory = GWT.create(AppRequestFactory.class);
      requestFactory.initialize(eventBus);
      return requestFactory;
   }*/
}
