/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.principal;

import br.edu.primefaces.modelo.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class ListarPessoas {
    
    
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("K19_PU");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT p FROM Pessoa p");
        
        List<Pessoa> pessoas = query.getResultList();
        
        for(Pessoa p: pessoas){
            
            System.out.println("Pessoa:" +p.getNome());
        }
        
    }
}
