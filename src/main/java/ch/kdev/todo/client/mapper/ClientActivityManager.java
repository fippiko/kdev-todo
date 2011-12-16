package ch.kdev.todo.client.mapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class ClientActivityManager extends ActivityManager {

   @Inject
   public ClientActivityManager(ActivityMapper mapper, EventBus eventBus) {
      super(mapper, eventBus);
   }
}
