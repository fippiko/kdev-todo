package ch.kdev.todo.client.view;

import ch.kdev.todo.client.activity.ActivityFactoryModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({ViewFactoryDesktopModule.class, ActivityFactoryModule.class})
public interface ViewFactoryDesktop extends ViewFactory {

}
