package ch.kdev.todo.client.view.widgets.messagebox.error;

import ch.kdev.todo.client.view.widgets.IBaseWidget;

public interface IErrorMessageBox extends IBaseWidget {
   public interface Presenter {
      void helpRequested();
      void confirmed();
   }

   public void show();
   public void close();
   public void setErrorMessage(String errorMessage);
   public String getErrorMessage(String errorMessage);
}
