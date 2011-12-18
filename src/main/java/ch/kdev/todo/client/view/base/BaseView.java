package ch.kdev.todo.client.view.base;

import ch.kdev.todo.client.activity.base.IBaseActivity;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.messagebox.error.IErrorMessageBox;

import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Inject;

public class BaseView<T> extends Composite implements IBaseView {

   @Inject
   IViewFactory viewFactory;
   
   private IBaseActivity activity;

   @Override
   public void setActivity(IBaseActivity activity) {
      this.activity = activity;
   }

   @SuppressWarnings("unchecked")
   public T getActivity() {
      // if this fails, it was a wrong presenter added, shame on you!
      return (T) this.activity;
   }

   @Override
   public void showError(String errorMessage) {
      IErrorMessageBox errorMessageBox = this.viewFactory.createErrorMessageBox();
      errorMessageBox.setView(this);
      errorMessageBox.setErrorMessage(errorMessage);
      errorMessageBox.show();
   }
}
