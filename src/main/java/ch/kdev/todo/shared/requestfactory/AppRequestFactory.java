package ch.kdev.todo.shared.requestfactory;

import com.google.gwt.inject.client.GinModules;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

@GinModules({AppRequestFactoryModule.class})
public interface AppRequestFactory extends RequestFactory {
   ProjectRequest projectRequest();
}