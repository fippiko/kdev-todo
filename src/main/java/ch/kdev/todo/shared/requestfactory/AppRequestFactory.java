package ch.kdev.todo.shared.requestfactory;

import ch.kdev.todo.client.activity.ActivityFactoryModule;

import com.google.gwt.inject.client.GinModules;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

@GinModules({AppRequestFactoryModule.class, ActivityFactoryModule.class})
public interface AppRequestFactory extends RequestFactory {
   ProjectRequest projectRequest();
}