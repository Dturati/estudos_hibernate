package br.com.david.criteria;

import br.com.david.model.Funcionario;
import br.com.david.model.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaSelectFromDoisDepartamento {
    public static void main(String[] args) {

        System.out.println("Agregação");

        Transaction transaction = null;

        Session session = HibernateSession.getSessionFactory().openSession();

        transaction = session.getTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

        Root<Funcionario> root = criteriaQuery.from(Funcionario.class);
        criteriaQuery.multiselect(root.get("nome"),root.get("salario"));
        Query<Object[]> query = session.createQuery(criteriaQuery);
        List<Object[]> list = query.getResultList();

        for (Object[] objects : list){
            System.out.println(objects[0]+ " "+ objects[1]);
        }
    }
}
