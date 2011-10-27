package ch.kdev.todo.client;

import ch.kdev.todo.client.activity.ActivityFactory;
import ch.kdev.todo.client.view.ViewFactory;
import ch.kdev.todo.client.view.ViewFactoryDesktop;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;
import ch.kdev.todo.shared.requestfactory.AppRequestFactoryProvider;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class ClientFactoryDesktopModule extends AbstractGinModule {

   @Override
   protected void configure() {

      bind(ClientFactory.class).to(ClientFactoryDesktop.class).in(Singleton.class);

      bind(ActivityFactory.class).in(Singleton.class);
      bind(ViewFactory.class).to(ViewFactoryDesktop.class).in(Singleton.class);

      bind(EventBus.class).to(SimpleEventBus.class); // TODO why is this needed?
      bind(AppRequestFactory.class).toProvider(AppRequestFactoryProvider.class);
   }
}
