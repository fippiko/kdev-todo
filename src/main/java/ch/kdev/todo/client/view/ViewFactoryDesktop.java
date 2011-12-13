package ch.kdev.todo.client.view;

import ch.kdev.todo.client.AppMainFactoryDesktopModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({AppMainFactoryDesktopModule.class, ViewFactoryDesktopModule.class})
public interface ViewFactoryDesktop extends ViewFactory {
   
}
