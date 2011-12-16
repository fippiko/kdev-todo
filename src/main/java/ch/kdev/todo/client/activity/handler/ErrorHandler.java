package ch.kdev.todo.client.activity.handler;

import ch.kdev.todo.client.activity.handler.base.BaseHandler;
import ch.kdev.todo.client.view.factory.IViewFactory;
import ch.kdev.todo.client.view.messagebox.error.IErrorMessageBox;

import com.google.inject.Inject;

public class ErrorHandler extends BaseHandler implements IErrorMessageBox.Presenter {
   @Inject
   private IViewFactory     viewFactory;

   private IErrorMessageBox currentMessageBox;

   public ErrorHandler() {

   }

   public void handleError(String errorMessage) {
      this.currentMessageBox = this.viewFactory.createErrorMessageBox();

      this.currentMessageBox.setErrorMessage(errorMessage);

      this.currentMessageBox.show();
   }

   @Override
   public void helpRequested() {
      this.currentMessageBox.close();
      this.currentMessageBox = null;
   }

   @Override
   public void confirmed() {
      this.currentMessageBox.close();
      this.currentMessageBox = null;
   }
}
