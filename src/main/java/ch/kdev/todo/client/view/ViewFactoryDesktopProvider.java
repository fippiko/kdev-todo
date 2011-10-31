package ch.kdev.todo.client.view;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

public class ViewFactoryDesktopProvider implements Provider<ViewFactoryDesktop> {

   private static ViewFactoryDesktop viewFactory = null;

   @Override
   public ViewFactoryDesktop get() {
      if(viewFactory == null){
         viewFactory =  GWT.create(ViewFactoryDesktop.class);
      }
      return viewFactory;
   }
}