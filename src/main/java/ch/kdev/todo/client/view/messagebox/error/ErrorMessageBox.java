package ch.kdev.todo.client.view.messagebox.error;

import ch.kdev.todo.client.activity.base.IBaseActivity;
import ch.kdev.todo.client.view.base.BaseView;
import ch.kdev.todo.client.view.messagebox.BaseWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public class ErrorMessageBox extends BaseWidget implements IErrorMessageBox {
   private static ErrorMessageBoxDesktopUiBinder uiBinder = GWT.create(ErrorMessageBoxDesktopUiBinder.class);

   @UiField
   DialogBox                                     dialogBox;

   @UiField
   Button                                        okButton;

   interface ErrorMessageBoxDesktopUiBinder extends UiBinder<Widget, ErrorMessageBox> {
   }

   // @UiField
   // TextBox descriptionTextBox;
   
   public ErrorMessageBox() {
      uiBinder.createAndBindUi(this);
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
   void onOkButtonClicked(ClickEvent event) {
      this.close();
   }

   void onHelpButtonClicked(ClickEvent event) {
      //this.getActivity().handleError("error");
   }

   @Override
   public void show() {
      this.dialogBox.show();
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
