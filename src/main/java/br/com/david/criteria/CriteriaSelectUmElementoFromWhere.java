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

public class CriteriaSelectUmElementoFromWhere {
    public static void main(String[] args) {

        Transaction transaction = null;
        Session session = HibernateSession.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Root<Funcionario> root = query.from(Funcionario.class);
        query.select(root.<String>get("nome")).where(criteriaBuilder.equal(root.get("id"),2L));
        Query<String> stringQuery = session.createQuery(query);
        List<String> funcionarioList = stringQuery.getResultList();

        for (String funcionario : funcionarioList){
            System.out.println(funcionario);
        }

    }
}
