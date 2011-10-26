package ch.kdev.todo.client.activity.provider;

import javax.inject.Provider;

import com.google.inject.Inject;

import ch.kdev.todo.client.ClientFactory;
import ch.kdev.todo.client.activity.project.AddProjectActivity;
import ch.kdev.todo.client.activity.project.ManageProjectsActivity;
import ch.kdev.todo.client.ui.project.add.AddProjectView;
import ch.kdev.todo.client.ui.project.manage.ManageProjectsView;

public class AddProjectActivityProvider implements Provider<AddProjectActivity> {

   private ClientFactory      clientFactory;
   private AddProjectView     view;

   @Inject
   public AddProjectActivityProvider(AddProjectView view, ClientFactory clientFactory) {
      this.clientFactory = clientFactory;
      this.view = view;
   }

   @Override
   public AddProjectActivity get() {
      return new AddProjectActivity(this.view, this.clientFactory);
   }

}
