package br.unitins.DAO;

import java.util.List;

public interface DAO<T> {
   public T inserir(  T obj);
   public void deletar(  T obj);
   public T atualizar(  T obj);
   public T buscar(  Integer id);
   public List<T> buscarTodos();
  
}
