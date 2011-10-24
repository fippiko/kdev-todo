package ch.kdev.todo.client.ui.project.view;

import ch.kdev.todo.shared.proxy.ProjectProxy;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface ViewProjectView extends IsWidget {

   public interface Presenter {
      void goTo(Place place);

      void editProject();
   }

   void setPresenter(Presenter listener);

   void setProjectAttributes(ProjectProxy project);
}
