package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("FieldCanBeLocal")
public class Util {
    private static final String HOSTNAME = "localhost";
    private static final String DBNAME = "draftPPDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3305";
    private static final String CONNECTION_URL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME;
    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static class HibernateUtil {
        private static SessionFactory sessionFactory;

        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();

                    Properties settings = new Properties();
                    settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/draftPPDB?useSSL=false");
                    settings.put(Environment.USER, "root");
                    settings.put(Environment.PASS, "3305");
                    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

                    settings.put(Environment.SHOW_SQL, "false");

                    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                    configuration.addProperties(settings);
                    configuration.addAnnotatedClass(User.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build();
                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return sessionFactory;
        }
    }
}
