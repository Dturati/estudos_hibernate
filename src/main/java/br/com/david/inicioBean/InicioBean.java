package br.com.david.inicioBean;

import br.com.david.model.HibernateSession;
import br.com.david.model.User;
import br.com.david.model.UserModel;
import org.hibernate.Session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ConversationScoped
public class InicioBean implements Serializable {

    private String nome;

    private String campo;

    @PostConstruct
    public void init(){
        System.out.println("InicioBean");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void users(){
        System.out.println(this.campo);
        Session session = HibernateSession.getSessionFactory().openSession();
        UserModel userModel = new UserModel();
        User user = userModel.getUsers(session);
        this.nome = user.getName();
    }

}
