package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.ActivityFactory;
import ch.kdev.todo.client.view.ViewFactory;

import com.google.gwt.inject.client.Ginjector;

public interface ClientFactory extends Ginjector {

   ActivityFactory getActivityProvider();

   ViewFactory getViewProvider();

   // AppRequestFactory getRequestFactory();
}
