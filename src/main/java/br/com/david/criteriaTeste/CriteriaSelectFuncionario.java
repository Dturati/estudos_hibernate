package br.com.david.criteriaTeste;

import br.com.david.model.Funcionario;
import br.com.david.model.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.criteria.*;

import org.hibernate.query.Query;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaSelectFuncionario {
    public static void main(String[] args) {

        Transaction transaction = null;
        Session session = HibernateSession.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteriaQuery = criteriaBuilder.createQuery(Funcionario.class);
        Root<Funcionario> root = criteriaQuery.from(Funcionario.class);
        criteriaQuery.select(root);
        Query<Funcionario> q = session.createQuery(criteriaQuery);

        List<Funcionario> funcionarios = q.getResultList();

        transaction.commit();;
        for (Funcionario funcionario : funcionarios){
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getSalario());
        }
    }
}
