package br.com.david.criteriaTeste;

import br.com.david.model.Funcionario;
import br.com.david.model.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TesteInsertFuncionario {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Pedra");
        funcionario.setCargo("Recepção");
        funcionario.setSalario(4000);

        Transaction transaction = null;
        Session session = HibernateSession.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        session.save(funcionario);
        transaction.commit();

    }
}
