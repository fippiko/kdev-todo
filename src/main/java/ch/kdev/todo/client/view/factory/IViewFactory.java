package ch.kdev.todo.client.view.factory;

import ch.kdev.todo.client.factory.ClientFactoryModule;
import ch.kdev.todo.client.view.layout.IAppLayout;
import ch.kdev.todo.client.view.mainmenu.IMainMenuView;
import ch.kdev.todo.client.view.project.add.IAddProjectView;
import ch.kdev.todo.client.view.project.edit.IEditProjectView;
import ch.kdev.todo.client.view.project.manage.IManageProjectsView;
import ch.kdev.todo.client.view.project.view.IViewProjectView;
import ch.kdev.todo.client.view.resources.ClientLabels;
import ch.kdev.todo.client.view.resources.ClientResources;
import ch.kdev.todo.client.view.task.add.IAddTaskView;
import ch.kdev.todo.client.view.widgets.messagebox.error.IErrorMessageBox;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import eu.maydu.gwt.validation.client.ValidationProcessor;

@GinModules({ClientFactoryModule.class, ViewFactoryModule.class})
public interface IViewFactory extends Ginjector {

   // layout
   IMainMenuView getMainMenuView();
   IAppLayout getClientLayout();

   // project - views
   IViewProjectView getViewProjectView();
   IEditProjectView getEditProjectView();
   IAddProjectView getAddProjectView();
   IManageProjectsView getManageProjectsView();

   // task - views
   IAddTaskView getAddTaskView();

   // widgets
   IErrorMessageBox createErrorMessageBox();

   // resources
   ClientResources getClientResources();
   ClientLabels getClientLabels();

   // various
   ValidationProcessor getValidator();
}
