package ch.kdev.todo.client.factory;

import ch.kdev.todo.client.activity.factory.ActivityFactoryModule;
import ch.kdev.todo.client.activity.factory.IActivityFactory;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.factory.ViewFactoryModule;
import ch.kdev.todo.shared.requestfactory.IRequestFactory;
import ch.kdev.todo.shared.requestfactory.RequestFactoryModule;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({ClientFactoryModule.class, ActivityFactoryModule.class, ViewFactoryModule.class, RequestFactoryModule.class})
public interface IClientFactory extends Ginjector {

   IActivityFactory getActivityFactory();
   
   IViewFactory getViewFactory();
   
   IRequestFactory getRequestFactory();

}
