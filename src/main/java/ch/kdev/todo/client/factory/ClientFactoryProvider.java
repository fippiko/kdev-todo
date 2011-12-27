package ch.kdev.todo.client.factory;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

public class ClientFactoryProvider implements Provider<IClientFactory> {
   private static IClientFactory clientFactoryInstance;

   @Override
   public IClientFactory get() {
      if (clientFactoryInstance == null) {
         clientFactoryInstance = GWT.create(IClientFactory.class);
      }

      return clientFactoryInstance;
   }
}
