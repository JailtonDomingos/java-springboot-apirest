package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
    public static void main(String[] args) {
        
        // Instanciamento do objeto JPA utilizado para persistir dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // Necessário dar um transaction para persistir os dados no banco. Isso quando não é uma simples.
        // Método "Persist" é utilizado para conexão com o banco.
        
        Pessoa p1 = new Pessoa(null, "Jailton Domingos", "jailton@gmail.com");
        Pessoa p2 = new Pessoa(null, "Caroline Domingos", "caroline@gmail.com");
        Pessoa p3 = new Pessoa(null, "Orival Domingos", "orival@gmail.com");

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();

        // Busca do objeto-relacional no banco utilizando o ID
        Pessoa pessoaFind = em.find(Pessoa.class, 2);
        System.out.println(pessoaFind);

        // Para o delete no database necessita também iniciar o transaction
        // O EntityManager Remove necessita que o obeto esteja supervisionado, ou seja, tenha acabado de ser criado ou feito uma busca(EntityManager Find) dele no banco. 
        // Isso antes de dar Close do Transaction
        em.getTransaction().begin();
        
        Pessoa pessoaRemove = em.find(Pessoa.class, 3);
        em.remove(pessoaRemove);

        em.getTransaction().commit();

        System.out.println("Pronto!");
        em.close();
        emf.close();



    }
}
