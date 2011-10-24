package ch.kdev.todo.client;

import ch.kdev.todo.client.ui.layout.AppLayout;
import ch.kdev.todo.client.ui.mainmenu.MainMenuView;
import ch.kdev.todo.client.ui.project.add.AddProjectView;
import ch.kdev.todo.client.ui.project.edit.EditProjectView;
import ch.kdev.todo.client.ui.project.manage.ManageProjectsView;
import ch.kdev.todo.client.ui.project.view.ViewProjectView;
import ch.kdev.todo.shared.requestfactory.AppRequestFactory;

import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory extends Ginjector {
   EventBus getEventBus();

   PlaceController getPlaceController();

   AppRequestFactory getRequestFactory();

   AppPresenter getAppController();

   ManageProjectsView getManageProjectsView();

   MainMenuView getMainMenuView();
   
   ViewProjectView getViewProjectView();

   EditProjectView getEditProjectView();

   AddProjectView getAddProjectView();

   AppLayout getAppLayout();

   
}
