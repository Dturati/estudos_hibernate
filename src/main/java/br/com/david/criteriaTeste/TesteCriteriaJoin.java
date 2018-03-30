package br.com.david.criteriaTeste;

import br.com.david.model.Departamento;
import br.com.david.model.Funcionario;
import br.com.david.model.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TesteCriteriaJoin {
    public static void main(String[] args) {

        Transaction transaction =  null;

        Session session = HibernateSession.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Funcionario> funcionarioRoot = criteriaQuery.from(Funcionario.class);
        Root<Departamento> departamentoRoot = criteriaQuery.from(Departamento.class);
        criteriaQuery.multiselect(funcionarioRoot,departamentoRoot);
        criteriaQuery.where(criteriaBuilder.equal(funcionarioRoot.get("id"),departamentoRoot.get("id")));
        Query<Object[]> query = session.createQuery(criteriaQuery);
        List<Object[]> objects = query.getResultList();

        for (Object[] objects1 :objects){
            Funcionario funcionario = (Funcionario)objects1[0];
            Departamento departamento = (Departamento)objects1[1];
            System.out.println(funcionario.getNome()+ " " + departamento.getNome());
        }

    }
}
