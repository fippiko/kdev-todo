package ch.kdev.todo.client.view.factory;

import ch.kdev.todo.client.factory.ClientFactoryModule;
import ch.kdev.todo.client.view.layout.IAppLayout;
import ch.kdev.todo.client.view.mainmenu.IMainMenuView;
import ch.kdev.todo.client.view.project.add.IAddProjectView;
import ch.kdev.todo.client.view.project.edit.IEditProjectView;
import ch.kdev.todo.client.view.project.manage.IManageProjectsView;
import ch.kdev.todo.client.view.project.view.IViewProjectView;
import ch.kdev.todo.client.view.task.add.IAddTaskView;
import ch.kdev.todo.client.view.widgets.messagebox.error.IErrorMessageBox;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({ClientFactoryModule.class, ViewFactoryModule.class})
public interface IViewFactory extends Ginjector {
   IMainMenuView getMainMenuView();

   IViewProjectView getViewProjectView();

   IEditProjectView getEditProjectView();

   IAddProjectView getAddProjectView();

   IManageProjectsView getManageProjectsView();
   
   IAddTaskView getAddTaskView();

   IAppLayout getClientLayout();

   IErrorMessageBox createErrorMessageBox();
}
