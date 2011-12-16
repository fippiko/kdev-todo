package ch.kdev.todo.client.view.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface ClientResources extends ClientBundle {
   public static final ClientResources instance = GWT.create(ClientResources.class);

   @Source("../resources/ch/kdev/todo/client/view/resources/AppStyleDesktop.css")
   public ClientStyleExt css();
}
