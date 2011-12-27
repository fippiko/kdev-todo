package ch.kdev.todo.client.activity.factory;

import ch.kdev.todo.client.activity.main.MainActivity;
import ch.kdev.todo.client.activity.project.AddProjectActivity;
import ch.kdev.todo.client.activity.project.EditProjectActivity;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.activity.project.ViewProjectActivity;
import ch.kdev.todo.client.activity.task.AddTaskActivity;
import ch.kdev.todo.client.factory.ClientFactoryModule;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;

@GinModules({ClientFactoryModule.class, ActivityFactoryModule.class})
public interface IActivityFactory extends Ginjector {
   EventBus getEventBus();

   ActivityManager getActivityManager();
   ActivityMapper getActivityMapper();

   PlaceController getPlaceController();
   PlaceHistoryMapper getPlaceHistoryMapper();
   PlaceHistoryHandler getPlaceHistoryHandler();

   MainActivity getMainActivity();

   // Project-Activities
   ManageProjectsActivity getManageProjectsActivity();
   AddProjectActivity getAddProjectActivity();
   ViewProjectActivity getViewProjectActivity();
   EditProjectActivity getEditProjectActivity();

   // task - activities
   AddTaskActivity getAddTaskActivity();
}
