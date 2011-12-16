package ch.kdev.todo.shared.requestfactory;

import ch.kdev.todo.client.activity.factory.IActivityFactory;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class RequestFactoryProvider implements Provider<IRequestFactory> {

   // @Inject
   // EventBus eventBus;

   @Inject
   IActivityFactory activityFactory;

   @Override
   public IRequestFactory get() {
      IRequestFactory appRequestFactory = GWT.create(IRequestFactory.class);
      appRequestFactory.initialize(activityFactory.getEventBus());
      return appRequestFactory;
   }
}