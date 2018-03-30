package br.com.david.criteriaTeste;

import br.com.david.model.Departamento;
import br.com.david.model.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CriteriaSelecFromWhereDepartamento {
    public static void main(String[] args) {

        Transaction transaction = null;

        Session session = HibernateSession.getSessionFactory().openSession();

        transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Departamento> query = criteriaBuilder.createQuery(Departamento.class);

        Root<Departamento> departamentoRoot = query.from(Departamento.class);

        query.select(departamentoRoot).where(criteriaBuilder.equal(departamentoRoot.get("id"),2L));
        Query<Departamento> departamentoQuery = session.createQuery(query);
        Departamento departamento = departamentoQuery.getSingleResult();
        System.out.println("Nome Departamento: "+departamento.getNome());

        transaction.commit();
    }
}
