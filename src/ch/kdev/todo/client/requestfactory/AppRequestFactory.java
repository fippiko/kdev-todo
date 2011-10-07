package ch.kdev.todo.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface AppRequestFactory extends RequestFactory {

   ProjectRequest projectRequest();
}