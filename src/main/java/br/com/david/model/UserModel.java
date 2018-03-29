package br.com.david.model;

import org.hibernate.Session;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import br.com.david.model.User;

public class UserModel implements Serializable{
    public User getUsers(Session session){
       User user = session.find(User.class,1);
        System.out.println(user.getName());
        return user;
    }
}
