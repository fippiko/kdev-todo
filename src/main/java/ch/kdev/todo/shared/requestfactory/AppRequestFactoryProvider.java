package ch.kdev.todo.shared.requestfactory;

import ch.kdev.todo.client.activity.ActivityFactory;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AppRequestFactoryProvider implements Provider<AppRequestFactory> {

   //@Inject
   //EventBus eventBus;
   
   @Inject
   ActivityFactory activityFactory;

   @Override
   public AppRequestFactory get() {
      AppRequestFactory appRequestFactory = GWT.create(AppRequestFactory.class);
      appRequestFactory.initialize(activityFactory.getEventBus());
      return appRequestFactory;
   }
}