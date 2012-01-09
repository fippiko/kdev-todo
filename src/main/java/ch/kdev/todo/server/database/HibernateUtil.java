package ch.kdev.todo.server.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allen_sauer.gwt.log.client.Log;

public class HibernateUtil {
   private static final SessionFactory sessionFactory = buildSessionFactory();

   private static SessionFactory buildSessionFactory() {
      try {
         // Create the SessionFactory from hibernate.cfg.xml
         return new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
         Log.error("SessionFactory:buildSessionFactory()", ex);
         throw new ExceptionInInitializerError(ex);
      }
   }

   public static SessionFactory getSessionFactory() {
      return sessionFactory;
   }

   public static Session getNewSession() {
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();

      return session;
   }

}
