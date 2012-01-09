package ch.kdev.todo.client.activity.factory;

import ch.kdev.todo.client.activity.project.AddProjectActivity;
import ch.kdev.todo.client.activity.project.EditProjectActivity;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.activity.project.ViewProjectActivity;
import ch.kdev.todo.client.activity.task.AddTaskActivity;
import ch.kdev.todo.client.mapper.ClientActivityManager;
import ch.kdev.todo.client.mapper.ClientActivityMapper;
import ch.kdev.todo.client.mapper.ClientPlaceHistoryHandler;
import ch.kdev.todo.client.mapper.ClientPlaceHistoryMapper;
import ch.kdev.todo.client.place.ClientPlaceController;

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
      bind(ActivityMapper.class).to(ClientActivityMapper.class).in(Singleton.class);
      bind(ActivityManager.class).to(ClientActivityManager.class).in(Singleton.class);

      bind(PlaceHistoryMapper.class).to(ClientPlaceHistoryMapper.class).in(Singleton.class);
      bind(PlaceHistoryHandler.class).to(ClientPlaceHistoryHandler.class).in(Singleton.class);

      bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
      bind(PlaceController.class).to(ClientPlaceController.class).in(Singleton.class);

      bind(ManageProjectsActivity.class).in(Singleton.class);
      bind(AddProjectActivity.class);
      bind(EditProjectActivity.class);
      bind(ViewProjectActivity.class);

      bind(AddTaskActivity.class);
   }
}
