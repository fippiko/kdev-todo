package ch.kdev.todo.client.activity;

import ch.kdev.todo.client.ClientFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class BasePresenter extends AbstractActivity {

   private ClientFactory clientFactory;

   private Boolean       manualNavigation;

   public BasePresenter(ClientFactory clientFactory) {
      this.clientFactory = clientFactory;

      this.manualNavigation = false;
   }

   @Override
   public void start(AcceptsOneWidget panel, EventBus eventBus) {

   }

   public void goTo(Place place) {
      this.manualNavigation = true;
      this.clientFactory.getPlaceController().goTo(place);
   }

   public Boolean isManualNavigation() {
      return this.manualNavigation;
   }

   public ClientFactory getClientFactory() {
      return this.clientFactory;
   }

}
