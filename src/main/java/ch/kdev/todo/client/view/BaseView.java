package ch.kdev.todo.client.view;

import ch.kdev.todo.client.activity.base.IBaseActivity;

import com.google.gwt.user.client.ui.Composite;

public class BaseView<T> extends Composite implements IBaseView {

   private IBaseActivity presenter;

   @Override
   public void setActivity(IBaseActivity presenter) {
      this.presenter = presenter;
   }

   @SuppressWarnings("unchecked")
   public T getPresenter() {
      // if this fails, it was a wrong presenter added, shame on you!
      return (T) this.presenter;
   }
}
