package ch.kdev.todo.client.activity.factory;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

public class ActivityFactoryProvider implements Provider<IActivityFactory> {

   private static IActivityFactory activityFactory = null;

   @Override
   public IActivityFactory get() {
      if (activityFactory == null) {
         activityFactory = GWT.create(IActivityFactory.class);
      }
      return activityFactory;
   }
}