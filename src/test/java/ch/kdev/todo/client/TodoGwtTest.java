package ch.kdev.todo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;

public class TodoGwtTest extends GWTTestCase {

   @Override
   public String getModuleName() {
      return "ch.kdev.todo.Todo";
   }

   public void testClientFactory() {
      ClientFactoryDesktop clientFactory = GWT.create(ClientFactoryDesktop.class);

      assertNotNull(clientFactory);
      assertNotNull(clientFactory.getAppController());
      assertNotNull(clientFactory.getAppLayout());
      assertNotNull(clientFactory.getEventBus());
      assertNotNull(clientFactory.getPlaceController());
      assertNotNull(clientFactory.getRequestFactory());

      // test the views
      assertNotNull(clientFactory.getMainMenuView());
      assertNotNull(clientFactory.getAddProjectView());
      assertNotNull(clientFactory.getManageProjectsView());
      assertNotNull(clientFactory.getEditProjectView());
   }
}