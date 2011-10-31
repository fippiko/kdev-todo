package ch.kdev.todo.client.activity;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

public class ActivityFactoryProvider implements Provider<ActivityFactory> {

   private static ActivityFactory activityFactory = null;

   @Override
   public ActivityFactory get() {
      if(activityFactory == null){
         activityFactory =  GWT.create(ActivityFactory.class);
      }
      return activityFactory;
   }
}