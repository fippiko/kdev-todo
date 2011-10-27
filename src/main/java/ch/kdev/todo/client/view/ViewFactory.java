package ch.kdev.todo.client.view;

import ch.kdev.todo.client.view.layout.AppLayout;
import ch.kdev.todo.client.view.mainmenu.MainMenuView;
import ch.kdev.todo.client.view.project.add.AddProjectView;
import ch.kdev.todo.client.view.project.edit.EditProjectView;
import ch.kdev.todo.client.view.project.view.ViewProjectView;

import com.google.gwt.inject.client.Ginjector;

public interface ViewFactory extends Ginjector {

   MainMenuView getMainMenuView();

   ViewProjectView getViewProjectView();

   EditProjectView getEditProjectView();

   AddProjectView getAddProjectView();

   AppLayout getAppLayout();
}
