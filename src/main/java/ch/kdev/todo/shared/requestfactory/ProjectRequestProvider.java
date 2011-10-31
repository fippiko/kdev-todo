package ch.kdev.todo.shared.requestfactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ProjectRequestProvider implements Provider<ProjectRequest> {

   @Inject
   AppRequestFactory appRequestFactory;

   @Override
   public ProjectRequest get() {
      return appRequestFactory.projectRequest();
   }
}
