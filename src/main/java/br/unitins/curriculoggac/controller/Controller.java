package br.unitins.curriculoggac.controller;



import br.unitins.curriculoggac.Repository.Repository;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;


public abstract class Controller<T> {
	
	protected T entity = null;
	private Repository<T> repository = new Repository<T>();
	
	public Controller() {
		super();
		repository = new Repository<T>();
	}

	public abstract T getEntity();

	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	public void limpar() {
		setEntity(null);
	}
	
	
	protected void salvarPrincipal() throws RepositoryException {
		getRepository().save(getEntity());
		limpar();
		Util.addInfoMessage("Registro realizado com sucesso.");
	}
	

	public void salvar() {
		try {
			salvarPrincipal();
		} catch (RepositoryException e) {
			Util.addErrorMessage("Problema ao salvar, tente novamente ou entre em contato com a TI.");
		}
		
	}

	public void excluir() {
		try {
			getRepository().remove(getEntity());
			limpar();
			Util.addInfoMessage("Registro removido com sucesso.");
		} catch (RepositoryException e) {
			Util.addErrorMessage("Problema ao remover, tente novamente ou entre em contato com a TI.");
		}
		
	}
    
	

	protected Repository<T> getRepository() {
		return repository;
	}
	
	
    
}