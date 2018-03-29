package br.com.david.inicioBean;

import br.com.david.model.HibernateSession;
import br.com.david.model.User;
import org.hibernate.Session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class InicioBean implements Serializable {

    @PostConstruct
    public void init(){
        System.out.println("InicioBean");
    }

    public void testeHibernate(){
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
