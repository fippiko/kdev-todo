package ch.kdev.todo.client.view.messagebox;

import ch.kdev.todo.client.view.base.IBaseView;

import com.google.gwt.user.client.ui.IsWidget;

public interface IBaseWidget extends IsWidget {
   public void setView(IBaseView view);
}
