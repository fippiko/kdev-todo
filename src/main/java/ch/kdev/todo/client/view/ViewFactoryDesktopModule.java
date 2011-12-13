package ch.kdev.todo.client.view;

import ch.kdev.todo.client.view.layout.AppLayout;
import ch.kdev.todo.client.view.layout.AppLayoutDesktop;
import ch.kdev.todo.client.view.mainmenu.MainMenuView;
import ch.kdev.todo.client.view.mainmenu.MainMenuViewDesktop;
import ch.kdev.todo.client.view.project.add.AddProjectView;
import ch.kdev.todo.client.view.project.add.AddProjectViewDesktop;
import ch.kdev.todo.client.view.project.edit.EditProjectView;
import ch.kdev.todo.client.view.project.edit.EditProjectViewDesktop;
import ch.kdev.todo.client.view.project.manage.ManageProjectsView;
import ch.kdev.todo.client.view.project.manage.ManageProjectsViewDesktop;
import ch.kdev.todo.client.view.project.view.ViewProjectView;
import ch.kdev.todo.client.view.project.view.ViewProjectViewDesktop;
import ch.kdev.todo.client.view.resources.AppResourcesDesktop;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import eu.maydu.gwt.validation.client.DefaultValidationProcessor;
import eu.maydu.gwt.validation.client.ValidationProcessor;

public class ViewFactoryDesktopModule extends AbstractGinModule {

   @Override
   protected void configure() {
      bind(ValidationProcessor.class).to(DefaultValidationProcessor.class);
      
      bind(AppLayout.class).to(AppLayoutDesktop.class).in(Singleton.class);
      bind(MainMenuView.class).to(MainMenuViewDesktop.class).in(Singleton.class);

      bind(ManageProjectsView.class).to(ManageProjectsViewDesktop.class).in(Singleton.class);
      bind(ViewProjectView.class).to(ViewProjectViewDesktop.class);

      bind(AddProjectView.class).to(AddProjectViewDesktop.class);
      bind(EditProjectView.class).to(EditProjectViewDesktop.class);
   }
}
