package ch.kdev.todo.client.view.base;

import ch.kdev.todo.client.activity.base.IBaseActivity;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.widgets.messagebox.error.IErrorMessageBox;

import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Inject;

public class BaseView<Presenter extends IPresenter> extends Composite implements IBaseView {

   @Inject
   private IViewFactory viewFactory;

   private Presenter    presenter;
   
   @Override
   public void setPresenter(IBaseActivity baseActivity) {    
      this.presenter = (Presenter) baseActivity;
   }
   
   public Presenter getPresenter() {
      return (Presenter) this.presenter;
   }

   @Override
   public void showError(String errorMessage) {
      IErrorMessageBox errorMessageBox = this.viewFactory.createErrorMessageBox();
      errorMessageBox.setView(this);
      errorMessageBox.setErrorMessage(errorMessage);
      errorMessageBox.show();
   }

   
}
