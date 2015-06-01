package br.com.mrcsfelipe.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import br.com.mrcsfelipe.spring.entity.Tarefa;

@Service
public class JpaTarefaDao{
  
  @PersistenceContext(unitName="persistenceUnit")
  EntityManager manager;

  //sem construtor

    public void adiciona(Tarefa tarefa) {
      manager.persist(tarefa);
    }

    public void altera(Tarefa tarefa) {
      manager.merge(tarefa);
    }

    public List<Tarefa> lista() {
      return manager.createQuery("select t from Tarefa t")
        .getResultList();
    }
 
    public Tarefa buscaPorId(Integer id) {
      return manager.find(Tarefa.class, id);
    }

    public void remove(Tarefa tarefa) {
      Tarefa tarefaARemover = buscaPorId(tarefa.getId());
      manager.remove(tarefaARemover);
    }

	

	
   
}