package com.polytech.todolist.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import com.polytech.todolist.models.Task;

@Transactional
public class JpaTaskRepository implements TaskRepository {
	private DataSource dataSource;

    @PersistenceContext
    EntityManager TaskEntityManager;
    public JpaTaskRepository(DataSource dataSource) {
    	this.dataSource=dataSource;
    }
    
	public List<Task> fetchAll(String username) {
		Query query = TaskEntityManager.createQuery("SELECT s FROM Task s WHERE s.username=:username")
		.setParameter("username", username);
        return query.getResultList();
	}

	public List<Task> addTask(Task task) {
		TaskEntityManager.persist(task);
		return fetchAll(task.getUsername());
		
	}

	public List<Task> deleteTask(Long id,String username) {
		TaskEntityManager.createQuery("DELETE FROM Task s WHERE s.id = :id")
        .setParameter("id", id)
        .executeUpdate();
		return fetchAll(username);
		
	}

	public List<Task> updateDone(Task task) {
		TaskEntityManager.createQuery("UPDATE Task s SET s.done = :done WHERE s.id = :id")
        .setParameter("done", task.isDone())
        .setParameter("id", task.getId())
        .executeUpdate();
		return fetchAll(task.getUsername());
	}

	public List<Task> updateTask(Task task) {
		TaskEntityManager.createQuery("UPDATE Task s SET s.content = :content WHERE s.id = :id")
        .setParameter("content", task.getContent())
        .setParameter("id", task.getId())
        .executeUpdate();
		return fetchAll(task.getUsername());
		
	}

}

