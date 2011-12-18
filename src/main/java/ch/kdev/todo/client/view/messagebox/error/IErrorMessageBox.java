package ch.kdev.todo.client.view.messagebox.error;

import ch.kdev.todo.client.view.messagebox.IBaseWidget;

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
