package lk.ijse.hibernate.orm;


import lk.ijse.hibernate.orm.config.SessionFactoryConfig;
import lk.ijse.hibernate.orm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AppInitializer {
    public static void main(String[] args) {
//Save using save method
        Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();

        session.close();
    }
}
