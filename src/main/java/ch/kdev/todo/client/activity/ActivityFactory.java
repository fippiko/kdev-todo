package ch.kdev.todo.client.activity;

import ch.kdev.todo.client.AppMainFactoryDesktopModule;
import ch.kdev.todo.client.activity.project.AddProjectActivity;
import ch.kdev.todo.client.activity.project.EditProjectActivity;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.activity.project.ViewProjectActivity;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;

@GinModules({AppMainFactoryDesktopModule.class, ActivityFactoryModule.class})
public interface ActivityFactory extends Ginjector {   
   EventBus getEventBus();

   ActivityManager getActivityManager();
   ActivityMapper getActivityMapper();

   PlaceController getPlaceController();
   PlaceHistoryMapper getPlaceHistoryMapper();
   PlaceHistoryHandler getPlaceHistoryHandler();

   // Project-Activities
   MainActivity getMainActivity();
   ManageProjectsActivity getManageProjectsActivity();
   AddProjectActivity getAddProjectActivity();
   ViewProjectActivity getViewProjectActivity();
   EditProjectActivity getEditProjectActivity();
}
