package ch.kdev.todo.client.ui.project.edit;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface EditProjectView extends IsWidget {

   void setPresenter(Presenter listener);

   public interface Presenter {
      void goTo(Place place);
   }

   void setProject(String projectID);
}
