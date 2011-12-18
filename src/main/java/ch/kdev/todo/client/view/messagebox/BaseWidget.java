package ch.kdev.todo.client.view.messagebox;

import ch.kdev.todo.client.view.base.IBaseView;


public abstract class BaseWidget implements IBaseWidget{
   IBaseView view;
   
   public void setView(IBaseView view) {
      this.view = view;
   }
}
