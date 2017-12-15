/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.controller;

import br.edu.primefaces.modelo.Pessoa;
import br.edu.primefaces.repository.PessoaRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author renato
 */
@ManagedBean
@RequestScoped
public class PessoaManagedBean {

    public PessoaManagedBean() {
        
    }

    private Pessoa pessoa = new Pessoa();

    public void adicionaPessoa(Pessoa pessoa) {
        EntityManager manager = this.getEntityManager();
        PessoaRepository repo = new PessoaRepository(manager);
        repo.adicionaPessoa(this.pessoa);
        this.pessoa = new Pessoa();

    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
        return manager;

    }
    
    public List<Pessoa> getPessoas(){
        
        EntityManager manager = this.getEntityManager();
        PessoaRepository repo = new PessoaRepository(manager);
        return repo.buscaTodas();
        
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
