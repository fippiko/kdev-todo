package ch.kdev.todo.client.ui.project.add;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface AddProjectView extends IsWidget {

   void setPresenter(Presenter listener);

   public interface Presenter {
      void goTo(Place place);

      void addNewProject(String projectName, String projectDescription);
   }
}
