package ch.kdev.todo.client.view.base;

import ch.kdev.todo.client.activity.base.IBaseActivity;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.resources.ClientConstants;
import ch.kdev.todo.client.view.resources.ClientMessages;
import ch.kdev.todo.client.view.resources.ClientResources;
import ch.kdev.todo.client.view.resources.ClientStyleExt;
import ch.kdev.todo.client.view.widgets.messagebox.error.IErrorMessageBox;

import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Inject;

public class BaseView<Presenter extends IPresenter> extends Composite implements IBaseView {

   @Inject
   private IViewFactory viewFactory;

   private Presenter    presenter;

   @SuppressWarnings("unchecked")
   @Override
   public void setPresenter(IBaseActivity baseActivity) {
      // this will throw an runtime exception if the activity-type does not
      // match the Presenter
      this.presenter = (Presenter) baseActivity;
   }

   public Presenter getPresenter() {
      return (Presenter) this.presenter;
   }

   protected IViewFactory getViewFactory() {
      return this.viewFactory;
   }

   @Override
   public void showError(String errorMessage) {
      IErrorMessageBox errorMessageBox = this.viewFactory.createErrorMessageBox();
      errorMessageBox.setView(this);
      errorMessageBox.setErrorMessage(errorMessage);
      errorMessageBox.show();
   }

   protected ClientStyleExt getCssResource() {
      ClientResources clientResources = this.getClientResources();
      ClientStyleExt cssResource = clientResources.css();

      cssResource.ensureInjected();

      return cssResource;
   }

   protected ClientResources getClientResources() {
      return this.viewFactory.getClientResources();
   }

   protected ClientConstants getConstants() {
      return this.getViewFactory().getClientConstants();
   }

   protected ClientMessages getMessages() {
      return this.getViewFactory().getClientMessages();
   }
}
