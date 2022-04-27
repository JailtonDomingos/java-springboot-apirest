package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa(null, "Jailton Domingos", "jailton@gmail.com");
        Pessoa p2 = new Pessoa(null, "Caroline Domingos", "caroline@gmail.com");
        Pessoa p3 = new Pessoa(null, "Orival Domingos", "orival@gmail.com");

        
        // Instanciamento do objeto JPA utilizado para persistir dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // Necessário dar um transaction para persistir os dados no banco. Isso quando não é uma simples.
        // Método "Persist" é utilizado para conexão com o banco.
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();

        System.out.println("Pronto!");

    }
}
