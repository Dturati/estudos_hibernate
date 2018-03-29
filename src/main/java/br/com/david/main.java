package br.com.david;

import br.com.david.model.HibernateSession;
import br.com.david.model.User;
import org.hibernate.Session;

import java.util.Date;

public class main {
    public static void main(String[] args) {
        Session session = HibernateSession.getSessionFactory().openSession();
        System.out.println(session);
        session.beginTransaction();

        User user = new User();
        user.setName("David");
        user.setLastname("Turati");
        user.setUsername("Dturati");
        user.setCreateDate(new Date());
        session.save(user);
        session.getTransaction().commit();

        System.out.println(user.getName());

    }
}
