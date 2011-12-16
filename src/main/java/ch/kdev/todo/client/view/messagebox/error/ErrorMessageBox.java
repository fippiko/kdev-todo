package ch.kdev.todo.client.view.messagebox.error;

import ch.kdev.todo.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

public class ErrorMessageBox extends BaseView<ErrorHandler> implements IErrorMessageBox {
   private static ErrorMessageBoxDesktopUiBinder uiBinder = GWT.create(ErrorMessageBoxDesktopUiBinder.class);
   @UiField
   Button                                        okButton;

   interface ErrorMessageBoxDesktopUiBinder extends UiBinder<Widget, ErrorMessageBox> {
   }

   // @UiField
   // TextBox descriptionTextBox;

   public ErrorMessageBox() {
      // setWidget(uiBinder.createAndBindUi(this));
      setWidget(uiBinder.createAndBindUi(this));
   }

   @Override
   public void setErrorMessage(String errorMessage) {
      // descriptionTextBox.setText(errorMessage);
   }

   @Override
   public String getErrorMessage(String errorMessage) {
      // return descriptionTextBox.getText();
      return "";
   }

   @UiHandler("okButton")
   void onButtonClick(ClickEvent event) {
      this.close();
   }

   @Override
   public void show() {
      // TODO Auto-generated method stub

   }

   @Override
   public void close() {
      // TODO Auto-generated method stub

   }
}
