package ch.kdev.todo.client.mapper;

import ch.kdev.todo.client.AppPresenter;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class AppActivityManager extends ActivityManager{

   @Inject
   public AppActivityManager(ActivityMapper mapper, EventBus eventBus) {
      super(mapper, eventBus);
   }
}
