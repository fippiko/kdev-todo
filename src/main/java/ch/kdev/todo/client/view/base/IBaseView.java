package ch.kdev.todo.client.view.base;

import ch.kdev.todo.client.activity.base.IBaseActivity;

import com.google.gwt.user.client.ui.IsWidget;

public interface IBaseView extends IsWidget {

   public void setActivity(IBaseActivity activity);
   public void showError(String errorMessage);
}
