package ch.kdev.todo.client.view;

import ch.kdev.todo.client.activity.BasePresenterInterface;

import com.google.gwt.user.client.ui.IsWidget;

public interface BaseViewInterface extends IsWidget {

   public void setPresenter(BasePresenterInterface presenter);
}
