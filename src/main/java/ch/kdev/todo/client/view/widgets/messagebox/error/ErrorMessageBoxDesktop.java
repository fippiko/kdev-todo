package ch.kdev.todo.client.view.widgets.messagebox.error;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public class ErrorMessageBoxDesktop extends DialogBox implements ErrorMessageBox{
   private static ErrorMessageBoxDesktopUiBinder uiBinder = GWT.create(ErrorMessageBoxDesktopUiBinder.class);

   interface ErrorMessageBoxDesktopUiBinder extends UiBinder<Widget, ErrorMessageBoxDesktop> {
   }
   
   public ErrorMessageBoxDesktop(){
      setWidget(uiBinder.createAndBindUi(this));
   }
   
   @Override
   public void setErrorMessage(String errorMessage) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public String getErrorMessage(String errorMessage) {
      // TODO Auto-generated method stub
      return null;
   }

}
