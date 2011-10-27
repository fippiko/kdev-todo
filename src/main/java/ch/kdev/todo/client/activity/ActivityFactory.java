package ch.kdev.todo.client.activity;

import ch.kdev.todo.client.ClientFactoryDesktopModule;
import ch.kdev.todo.client.activity.project.AddProjectActivity;
import ch.kdev.todo.client.activity.project.EditProjectActivity;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.activity.project.ViewProjectActivity;
import ch.kdev.todo.client.view.ViewFactoryDesktopModule;
import ch.kdev.todo.shared.requestfactory.AppRequestFactoryModule;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;

@GinModules({ActivityFactoryModule.class, ViewFactoryDesktopModule.class, ClientFactoryDesktopModule.class, AppRequestFactoryModule.class})
public interface ActivityFactory extends Ginjector {

   EventBus getEventBus();

   PlaceController getPlaceController();

   ActivityManager getActivityManager();

   ActivityMapper getActivityMapper();

   PlaceHistoryMapper getPlaceHistoryMapper();

   PlaceHistoryHandler getPlaceHistoryHandler();

   AppActivity getAppActivity();

   // Project-Activities
   ManageProjectsActivity getManageProjectsActivity();
   AddProjectActivity getAddProjectActivity();
   ViewProjectActivity getViewProjectActivity();
   EditProjectActivity getEditProjectActivity();
}
