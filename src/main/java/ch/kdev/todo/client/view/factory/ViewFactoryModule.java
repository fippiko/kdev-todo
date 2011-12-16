package ch.kdev.todo.client.view.factory;

import ch.kdev.todo.client.view.layout.AppLayout;
import ch.kdev.todo.client.view.layout.IAppLayout;
import ch.kdev.todo.client.view.mainmenu.IMainMenuView;
import ch.kdev.todo.client.view.mainmenu.MainMenuView;
import ch.kdev.todo.client.view.messagebox.error.ErrorMessageBox;
import ch.kdev.todo.client.view.messagebox.error.IErrorMessageBox;
import ch.kdev.todo.client.view.project.add.AddProjectView;
import ch.kdev.todo.client.view.project.add.IAddProjectView;
import ch.kdev.todo.client.view.project.edit.EditProjectView;
import ch.kdev.todo.client.view.project.edit.IEditProjectView;
import ch.kdev.todo.client.view.project.manage.IManageProjectsView;
import ch.kdev.todo.client.view.project.manage.ManageProjectsView;
import ch.kdev.todo.client.view.project.view.IViewProjectView;
import ch.kdev.todo.client.view.project.view.ViewProjectView;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import eu.maydu.gwt.validation.client.DefaultValidationProcessor;
import eu.maydu.gwt.validation.client.ValidationProcessor;

public class ViewFactoryModule extends AbstractGinModule {

   @Override
   protected void configure() {
      bind(ValidationProcessor.class).to(DefaultValidationProcessor.class);

      bind(IAppLayout.class).to(AppLayout.class).in(Singleton.class);
      bind(IMainMenuView.class).to(MainMenuView.class).in(Singleton.class);

      bind(IManageProjectsView.class).to(ManageProjectsView.class).in(Singleton.class);
      bind(IViewProjectView.class).to(ViewProjectView.class);

      bind(IAddProjectView.class).to(AddProjectView.class);
      bind(IEditProjectView.class).to(EditProjectView.class);

      // handler
      bind(IErrorMessageBox.class).to(ErrorMessageBox.class);
   }
}
