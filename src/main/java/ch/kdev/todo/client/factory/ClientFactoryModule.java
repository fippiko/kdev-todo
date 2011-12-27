package ch.kdev.todo.client.factory;

import ch.kdev.todo.client.activity.factory.ActivityFactoryProvider;
import ch.kdev.todo.client.activity.factory.IActivityFactory;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.factory.ViewFactoryProvider;
import ch.kdev.todo.shared.requestfactory.IRequestFactory;
import ch.kdev.todo.shared.requestfactory.ProjectRequest;
import ch.kdev.todo.shared.requestfactory.ProjectRequestProvider;
import ch.kdev.todo.shared.requestfactory.RequestFactoryProvider;

import com.google.gwt.inject.client.AbstractGinModule;

public class ClientFactoryModule extends AbstractGinModule {

   @Override
   protected void configure() {
      // bind(IClientFactoryBase.class).to(IClientFactory.class);
      bind(IClientFactory.class).toProvider(ClientFactoryProvider.class);

      bind(IActivityFactory.class).toProvider(ActivityFactoryProvider.class);

      bind(IViewFactory.class).toProvider(ViewFactoryProvider.class);

      bind(IRequestFactory.class).toProvider(RequestFactoryProvider.class);

      bind(ProjectRequest.class).toProvider(ProjectRequestProvider.class);
   }
}
