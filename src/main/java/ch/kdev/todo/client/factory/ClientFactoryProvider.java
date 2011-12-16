package ch.kdev.todo.client.factory;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

public class ClientFactoryProvider implements Provider<IClientFactory> {
   private static IClientFactory mainFactoryInstance;

   @Override
   public IClientFactory get() {
      if (mainFactoryInstance == null) {
         mainFactoryInstance = GWT.create(IClientFactory.class);
      }

      return mainFactoryInstance;
   }
}
