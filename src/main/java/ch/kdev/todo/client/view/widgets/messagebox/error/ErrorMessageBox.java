package ch.kdev.todo.client.view.widgets.messagebox.error;

import ch.kdev.todo.client.view.widgets.BaseWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class ErrorMessageBox extends BaseWidget implements IErrorMessageBox {
   private static ErrorMessageBoxDesktopUiBinder uiBinder = GWT.create(ErrorMessageBoxDesktopUiBinder.class);

   @UiField
   DialogBox                                     dialogBox;
   @UiField
   Button                                        helpButton;
   @UiField
   Button                                        closeButton;
   @UiField
   TextArea                                      errorTextBox;

   interface ErrorMessageBoxDesktopUiBinder extends UiBinder<Widget, ErrorMessageBox> {
   }

   public ErrorMessageBox() {
      uiBinder.createAndBindUi(this);
   }

   @Override
   public void setErrorMessage(String errorMessage) {
      this.errorTextBox.setText(errorMessage);
   }

   @Override
   public String getErrorMessage(String errorMessage) {
      return this.errorTextBox.getText();
   }

   @UiHandler("helpButton")
   void onHelpButtonClicked(ClickEvent event) {
      // TODO goto errorhelp place
      // this.getActivity().goTo(new ErrorHelpPlace);
   }

   @UiHandler("closeButton")
   void onCloseButtonClicked(ClickEvent event) {
      this.close();
   }

   @Override
   public void show() {
      this.dialogBox.show();
      this.dialogBox.center();
   }

   @Override
   public void close() {
      this.dialogBox.hide();
   }

   @Override
   public Widget asWidget() {
      return this.dialogBox;
   }
}
