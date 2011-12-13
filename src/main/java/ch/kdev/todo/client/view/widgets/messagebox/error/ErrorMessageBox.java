package ch.kdev.todo.client.view.widgets.messagebox.error;

import com.google.gwt.user.client.ui.IsWidget;

public interface ErrorMessageBox extends IsWidget{
   public void setErrorMessage(String errorMessage);
   public String getErrorMessage(String errorMessage);
}
