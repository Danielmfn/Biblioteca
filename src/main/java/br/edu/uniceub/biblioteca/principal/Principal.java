package br.edu.uniceub.biblioteca.principal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Principal {
    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("BibliotecaHibernatePU")
                .createEntityManager();
        em.getTransaction();
        // Não deu tempo de popular
    }
}
