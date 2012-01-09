package ch.kdev.todo.client.view.widgets;

import ch.kdev.todo.client.view.base.IBaseView;

public abstract class BaseWidget implements IBaseWidget {
   IBaseView view;

   @Override
   public void setView(IBaseView view) {
      this.view = view;
   }

   protected IBaseView getView() {
      return this.view;
   }
}
