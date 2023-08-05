package lk.ijse.hibernate.orm.config;


import lk.ijse.hibernate.orm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryConfig {

    private static  SessionFactory sessionFactory;
    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.Properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        configuration.addAnnotatedClass(Customer.class).addAnnotatedClass(Customer.class);
        sessionFactory = configuration.setProperties(properties).buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
//        if(null==factoryConfig){
//            return factoryConfig = new SessionFactoryConfig();
//        }
//        return factoryConfig;
        return (null==factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig ;
    }

    public Session getSession(){
       /* StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Customer.class).getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();

//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        SessionFactory sessionFactory = metadata.buildSessionFactory();*/

        return sessionFactory.openSession();

    }


}
