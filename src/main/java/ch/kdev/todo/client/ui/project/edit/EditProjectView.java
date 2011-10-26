package ch.kdev.todo.client.ui.project.edit;

import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface EditProjectView extends IsWidget {

   public interface Presenter {
      void goTo(Place place);

      void saveProject();
   }

   void setPresenter(Presenter listener);

   void setProjectAttributes(ProjectProxy project);

   ProjectProxy getProjectAttributes(ProjectProxy editableProject);
}
