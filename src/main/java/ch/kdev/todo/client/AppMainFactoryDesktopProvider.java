package ch.kdev.todo.client;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

public class AppMainFactoryDesktopProvider implements Provider<AppMainFactoryDesktop> {
   private static AppMainFactoryDesktop mainFactoryInstance;

   @Override
   public AppMainFactoryDesktop get() {
      if (mainFactoryInstance == null) {
         mainFactoryInstance = GWT.create(AppMainFactoryDesktop.class);
      }

      return mainFactoryInstance;
   }
}
