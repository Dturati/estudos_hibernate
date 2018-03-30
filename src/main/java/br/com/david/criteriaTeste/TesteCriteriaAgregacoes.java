package br.com.david.criteriaTeste;

import br.com.david.model.Funcionario;
import br.com.david.model.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TesteCriteriaAgregacoes {
    public static void main(String[] args) {

        Transaction transaction = null;

        Session session = HibernateSession.getSessionFactory().openSession();

        transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        //Contar números de funcionários
        CriteriaQuery<Long> longCriteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Funcionario> funcionarioRoot = longCriteriaQuery.from(Funcionario.class);
        longCriteriaQuery.select(criteriaBuilder.count(funcionarioRoot));
        Query<Long> query = session.createQuery(longCriteriaQuery);
        Long cout = query.getSingleResult();
        System.out.println("Quantidade de funcionarios: "+cout);

        //Salário máximo
        CriteriaQuery<Double> doubleCriteriaQuery = criteriaBuilder.createQuery(Double.class);
        Root<Funcionario> funcionarioRoot1 = doubleCriteriaQuery.from(Funcionario.class);
        doubleCriteriaQuery.select(criteriaBuilder.max(funcionarioRoot1.<Double>get("salario")));
        Query<Double> doubleQuery = session.createQuery(doubleCriteriaQuery);
        Double salariomaximo = doubleQuery.getSingleResult();
        System.out.println("Salário máximo: "+salariomaximo);

        //Média dos salários
        CriteriaQuery<Double> doubleCriteriaQuery1 = criteriaBuilder.createQuery(Double.class);
        Root<Funcionario> funcionarioRoot2 = doubleCriteriaQuery1.from(Funcionario.class);
        doubleCriteriaQuery1.select(criteriaBuilder.avg(funcionarioRoot2.<Number>get("salario")));
        Query<Double> doubleQuery1 = session.createQuery(doubleCriteriaQuery1);
        double salarioMedio = doubleQuery1.getSingleResult();
        System.out.println("Salário médio; "+salarioMedio);

        //Distinct
        CriteriaQuery<Long> longCriteriaQuery1 = criteriaBuilder.createQuery(Long.class);
        Root<Funcionario> funcionarioRoot3 = longCriteriaQuery1.from(Funcionario.class);
        longCriteriaQuery1.select(criteriaBuilder.countDistinct(funcionarioRoot3));
        Query<Long>  longQuery = session.createQuery(longCriteriaQuery1);
        Long distinct = longQuery.getSingleResult();
        System.out.println("Distinct: "+distinct);

        transaction.commit();

    }
}
