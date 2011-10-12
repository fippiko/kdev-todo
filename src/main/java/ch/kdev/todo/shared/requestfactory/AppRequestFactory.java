package ch.kdev.todo.shared.requestfactory;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface AppRequestFactory extends RequestFactory {
   ProjectRequest projectRequest();
}