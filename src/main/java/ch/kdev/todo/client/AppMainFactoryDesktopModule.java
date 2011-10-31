package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.ActivityFactory;
import ch.kdev.todo.client.activity.ActivityFactoryProvider;
import ch.kdev.todo.client.view.ViewFactory;
import ch.kdev.todo.client.view.ViewFactoryDesktop;
import ch.kdev.todo.client.view.ViewFactoryDesktopProvider;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;
import ch.kdev.todo.shared.requestfactory.AppRequestFactoryProvider;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;
import ch.kdev.todo.shared.requestfactory.ProjectRequestProvider;

import com.google.gwt.inject.client.AbstractGinModule;

public class AppMainFactoryDesktopModule extends AbstractGinModule {

   @Override
   protected void configure() {
      bind(AppMainFactory.class).to(AppMainFactoryDesktop.class);
      bind(AppMainFactoryDesktop.class).toProvider(AppMainFactoryDesktopProvider.class);
      
      bind(ActivityFactory.class).toProvider(ActivityFactoryProvider.class);
      
      bind(ViewFactory.class).to(ViewFactoryDesktop.class);
      bind(ViewFactoryDesktop.class).toProvider(ViewFactoryDesktopProvider.class);
      
      bind(AppRequestFactory.class).toProvider(AppRequestFactoryProvider.class);
      
      bind(ProjectRequest.class).toProvider(ProjectRequestProvider.class);
   }
}
