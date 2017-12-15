/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.principal;

import br.edu.primefaces.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author renato
 */
public class GenerateSchema {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("K19_PU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Pessoa p = new Pessoa();
        p.setNome("Renato");
        manager.persist(p);
        manager.getTransaction().commit();
        
    }

}
