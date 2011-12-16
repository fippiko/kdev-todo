package ch.kdev.todo.client.factory;

import ch.kdev.todo.client.activity.factory.IActivityFactory;
import ch.kdev.todo.client.view.factory.IViewFactory;

import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface IClientFactoryBase extends Ginjector {
   IActivityFactory getActivityFactory();
   IViewFactory getViewFactory();
   RequestFactory getRequestFactory();
}
