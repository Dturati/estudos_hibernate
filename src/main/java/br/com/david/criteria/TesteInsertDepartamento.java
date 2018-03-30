package br.com.david.criteria;

import br.com.david.model.Departamento;
import br.com.david.model.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TesteInsertDepartamento {
    public static void main(String[] args) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Departamento departamento = new Departamento();
        departamento.setNome("Suporte");
        session.save(departamento);
        transaction.commit();

    }
}
