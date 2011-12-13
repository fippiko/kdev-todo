package ch.kdev.todo.client.view.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface AppResourcesDesktop extends ClientBundle{
   public static final AppResourcesDesktop INSTANCE = GWT.create(AppResourcesDesktop.class);
   
   @Source("../resources/ch/kdev/todo/client/view/resources/AppStyleDesktop.css")
   public AppStyleDesktopWorkArround css();
}
