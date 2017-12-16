/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.repository;

import br.edu.primefaces.modelo.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class PessoaRepository {

    Pessoa pessoa = new Pessoa();
    private EntityManager manager;

    public PessoaRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adicionaPessoa(Pessoa pessoa) {
        this.manager.persist(pessoa);

    }

    public List<Pessoa> buscaTodas() {
        Query query = manager.createNamedQuery("Pessoa.findALL");
        return query.getResultList();
    }
}
