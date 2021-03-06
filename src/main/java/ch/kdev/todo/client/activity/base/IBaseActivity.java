package ch.kdev.todo.client.activity.base;

import ch.kdev.todo.client.view.base.IBaseView;

public interface IBaseActivity {
   public IBaseView getView();

   public void handleError(String string);

   public boolean isLeaveWarningSuppressed();
   public void suppressLeaveWarning();
   public void suppressLeaveWarning(boolean suppress);
}
