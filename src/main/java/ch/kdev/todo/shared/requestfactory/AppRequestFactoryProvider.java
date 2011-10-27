package ch.kdev.todo.shared.requestfactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AppRequestFactoryProvider implements Provider<AppRequestFactory> {

   @Inject
   EventBus eventBus;

   @Override
   public AppRequestFactory get() {
      AppRequestFactory appRequestFactory = GWT.create(AppRequestFactory.class);
      appRequestFactory.initialize(eventBus);
      return appRequestFactory;
   }
}