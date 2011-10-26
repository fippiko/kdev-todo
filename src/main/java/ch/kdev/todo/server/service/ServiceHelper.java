package ch.kdev.todo.server.service;

import java.lang.reflect.Method;
import java.util.Hashtable;

import com.allen_sauer.gwt.log.client.Log;

public abstract class ServiceHelper {

   private static final String GETTER_PREFIX = "get";
   private static final String SETTER_PREFIX = "set";

   public static Object mergeObjectWithDelta(Class<?> objectClass, Object fullObject, Object deltaObject) {
      Log.debug("try to merge object with delta of the object (class = " + objectClass.toString() + ")");
      Log.debug("fullObject: " + fullObject.toString());
      Log.debug("deltaObject: " + deltaObject.toString());

      Hashtable<String, Object> getterValues = new Hashtable<String, Object>();
      Hashtable<String, Method> setterMethods = new Hashtable<String, Method>();

      for (Method method : objectClass.getMethods()) {
         if (method.getName().startsWith(GETTER_PREFIX)) {
            Log.debug("found getter method :" + method.getName());
            try {
               Object getterValue = method.invoke(deltaObject);

               if (getterValue != null) {
                  Log.debug("caching return value :" + getterValue.toString());
                  getterValues.put(method.getName().substring(GETTER_PREFIX.length()), getterValue);
               }
               else {
                  Log.debug("getter method " + method.getName() + " will be ignored, because the return value is null");
               }
            } catch (Exception e) {
               Log.warn("unable to execute getter method " + method.getName() + ". Return value won't be cached");
            }
         }

         if (method.getName().startsWith(SETTER_PREFIX)) {
            setterMethods.put(method.getName().substring(SETTER_PREFIX.length()), method);
         }
      }

      for (String methodKey : getterValues.keySet()) {
         if (setterMethods.containsKey(methodKey)) {
            Method setterMethod = setterMethods.get(methodKey);

            try {
               Object getterValue = getterValues.get(methodKey);

               Log.debug("try executing setter method " + setterMethod.getName() + ", with cached value: " + getterValue.toString());
               setterMethod.invoke(fullObject, getterValues.get(methodKey));
            } catch (Exception e) {
               Log.warn("unable to execute setter method " + setterMethod.getName());
            }
         }
      }

      return fullObject;
   }
}
