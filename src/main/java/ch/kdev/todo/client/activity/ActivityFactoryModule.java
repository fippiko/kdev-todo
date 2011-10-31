package ch.kdev.todo.client.activity;

import ch.kdev.todo.client.activity.project.AddProjectActivity;
import ch.kdev.todo.client.activity.project.EditProjectActivity;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.activity.project.ViewProjectActivity;
import ch.kdev.todo.client.mapper.AppActivityManager;
import ch.kdev.todo.client.mapper.AppActivityMapper;
import ch.kdev.todo.client.mapper.AppPlaceHistoryHandler;
import ch.kdev.todo.client.mapper.AppPlaceHistoryMapper;
import ch.kdev.todo.client.place.SimplePlaceController;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ActivityFactoryModule extends AbstractGinModule {

   @Override
   protected void configure() {
      
      bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);
      bind(ActivityManager.class).to(AppActivityManager.class).in(Singleton.class);

      bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);
      bind(PlaceHistoryHandler.class).to(AppPlaceHistoryHandler.class).in(Singleton.class);

      bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
      bind(PlaceController.class).to(SimplePlaceController.class).in(Singleton.class);
      
      bind(ManageProjectsActivity.class).in(Singleton.class);
      bind(AddProjectActivity.class);
      bind(EditProjectActivity.class);
      bind(ViewProjectActivity.class);
   }
}
