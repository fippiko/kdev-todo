package ch.kdev.todo.shared.requestfactory;

import com.google.gwt.inject.client.GinModules;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

@GinModules({RequestFactoryModule.class})
public interface IRequestFactory extends RequestFactory {

   ProjectRequest projectRequest();

   TaskRequest taskRequest();
}