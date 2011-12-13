package ch.kdev.todo.client.view;

import ch.kdev.todo.client.activity.BasePresenterInterface;

import com.google.gwt.user.client.ui.Composite;

public class BaseView<T> extends Composite implements BaseViewInterface {

   private BasePresenterInterface presenter;

   @Override
   public void setActivity(BasePresenterInterface presenter) {
      this.presenter = presenter;
   }

   @SuppressWarnings("unchecked")
   public T getPresenter() {
      // if this fails, it was a wrong presenter added, shame on you!
      return (T) this.presenter;
   }
}
