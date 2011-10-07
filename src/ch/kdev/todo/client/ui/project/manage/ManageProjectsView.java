package ch.kdev.todo.client.ui.project.manage;

import java.util.List;

import ch.kdev.todo.shared.model.Project;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface ManageProjectsView extends IsWidget {

   void setPresenter(Presenter listener);

   public interface Presenter {
      void goTo(Place place);

      List<Project> getProjects();
   }
}