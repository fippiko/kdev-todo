package ch.kdev.todo.client.view.factory;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

public class ViewFactoryProvider implements Provider<IViewFactory> {

   private static IViewFactory viewFactory = null;

   @Override
   public IViewFactory get() {
      if (viewFactory == null) {
         viewFactory = GWT.create(IViewFactory.class);
      }
      return viewFactory;
   }
}