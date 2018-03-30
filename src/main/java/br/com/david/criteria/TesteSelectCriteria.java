package br.com.david.criteria;

import br.com.david.model.Departamento;
import br.com.david.model.HibernateSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class TesteSelectCriteria {
    public static void main(String[] args) {
        Transaction transaction = null;

        Session session = HibernateSession.getSessionFactory().openSession();

        transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Departamento> query = criteriaBuilder.createQuery(Departamento.class);



    }
}
