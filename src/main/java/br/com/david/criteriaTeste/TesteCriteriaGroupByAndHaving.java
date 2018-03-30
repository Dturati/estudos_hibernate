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

public class TesteCriteriaGroupByAndHaving {
    public static void main(String[] args) {

        Transaction transaction = null;
        Session session = HibernateSession.getSessionFactory().openSession();
        transaction = session.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> funcionarioCriteriaQuery = criteriaBuilder.createQuery(Object[].class);

        Root<Funcionario> funcionarioRoot = funcionarioCriteriaQuery.from(Funcionario.class);

        funcionarioCriteriaQuery.multiselect(funcionarioRoot.get("nome"),funcionarioRoot.get("salario"),funcionarioRoot.get("departamento"));

        funcionarioCriteriaQuery.groupBy(funcionarioRoot.get("salario"),funcionarioRoot.get("departamento"));

        funcionarioCriteriaQuery.having(criteriaBuilder.greaterThan(funcionarioRoot.<Double>get("salario"),1500.0));

        Query<Object[]> query = session.createQuery(funcionarioCriteriaQuery);
        List<Object[]> objects = query.getResultList();
        for (Object[] objects1 : objects){
            Departamento departamento = (Departamento)objects1[2];
            System.out.println("Nome: " + objects1[0] + " Salário: " + objects1[1]+ " departamento: "+departamento.getNome());
        }

        transaction.commit();
    }
}
