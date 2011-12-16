package ch.kdev.todo.client.view.messagebox.error;

import ch.kdev.todo.client.view.IBaseView;

public interface IErrorMessageBox extends IBaseView {
   public interface Presenter {
      void helpRequested();
      void confirmed();
   }

   public void show();
   public void close();
   public void setErrorMessage(String errorMessage);
   public String getErrorMessage(String errorMessage);
}
