package ch.kdev.todo.shared.requestfactory;

import com.google.gwt.inject.client.AbstractGinModule;

public class AppRequestFactoryModule extends AbstractGinModule {

   @Override
   protected void configure() {
      bind(ProjectRequest.class).toProvider(ProjectRequestProvider.class);
   }

}