package hw.App;

import hw.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        SessionFactory  sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        for (int i = 0; i < 20; i++) {
            create(sessionFactory);
        }
        for (int i = 1; i < 10; i++) {
            read(sessionFactory,i);
        }
        for (int i = 1; i < 10; i++) {
            update(sessionFactory,i);
        }
        for (int i = 1; i < 10; i++) {
            delete(sessionFactory,i + 5);
        }



    }

    public static void create(SessionFactory sessionFactory){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Course course = Course.create();

            session.save(course);
            System.out.println("Object course save successfully");

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }
    }
    public static void read(SessionFactory sessionFactory,int id){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Course retrievedCourse = session.get(Course.class, id);

            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedCourse);

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }
    }
    public static void update(SessionFactory sessionFactory, int id){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Course retrievedCourse = session.get(Course.class, id);
            retrievedCourse.updateDuration();
            retrievedCourse.updateName();
            session.update(retrievedCourse);
            System.out.println("Object course update successfully");

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }
    }
    public static void delete(SessionFactory sessionFactory,int id){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Course retrievedCourse = session.get(Course.class, id);

            session.save(retrievedCourse);
            System.out.println("Object course delete successfully");

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }
    }
}

