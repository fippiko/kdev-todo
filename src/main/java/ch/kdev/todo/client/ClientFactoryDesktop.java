package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.ActivityFactoryModule;
import ch.kdev.todo.client.view.ViewFactoryDesktopModule;
import ch.kdev.todo.shared.requestfactory.AppRequestFactoryModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({ClientFactoryDesktopModule.class, ActivityFactoryModule.class, ViewFactoryDesktopModule.class, AppRequestFactoryModule.class})
public interface ClientFactoryDesktop extends ClientFactory {

}