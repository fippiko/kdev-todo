package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.ActivityFactory;
import ch.kdev.todo.client.activity.ActivityFactoryModule;
import ch.kdev.todo.client.view.ViewFactoryDesktop;
import ch.kdev.todo.client.view.ViewFactoryDesktopModule;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;
import ch.kdev.todo.shared.requestfactory.AppRequestFactoryModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({AppMainFactoryDesktopModule.class, ActivityFactoryModule.class, ViewFactoryDesktopModule.class, AppRequestFactoryModule.class})
public interface AppMainFactoryDesktop extends AppMainFactory{
   
   @Override
   ActivityFactory getActivityFactory();
   @Override
   ViewFactoryDesktop getViewFactory();
   @Override
   AppRequestFactory getRequestFactory();

}
