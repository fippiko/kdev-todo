package ch.kdev.todo.client.activity.provider;

import javax.inject.Provider;

import com.google.inject.Inject;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.ui.project.manage.ManageProjectsView;

public class ManageProjectsActivityProvider implements Provider<ManageProjectsActivity> {

   private ClientFactory      clientFactory;
   private ManageProjectsView view;

   @Inject
   public ManageProjectsActivityProvider(ManageProjectsView view, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.view = view;
   }

   @Override
   public ManageProjectsActivity get() {
      return new ManageProjectsActivity(this.view, this.clientFactory);
   }

}
