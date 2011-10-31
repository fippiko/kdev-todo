package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.ActivityFactory;
import ch.kdev.todo.client.view.ViewFactory;

import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface AppMainFactory extends Ginjector{
   ActivityFactory getActivityFactory();
   ViewFactory getViewFactory();
   RequestFactory getRequestFactory();
}
