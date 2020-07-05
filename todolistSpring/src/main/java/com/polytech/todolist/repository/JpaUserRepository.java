package com.polytech.todolist.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import com.polytech.todolist.models.Authorities;
import com.polytech.todolist.models.Users;

@Transactional
public class JpaUserRepository implements UserRepository {
	
	private DataSource dataSource;
	
	@PersistenceContext
    EntityManager userEntityManager;
	
	public JpaUserRepository(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public List<Users> findUsername(String username) {
		Query query=userEntityManager.createQuery("SELECT s FROM Users s WHERE s.username=:username")
				.setParameter("username", username);
		return query.getResultList();
	}
	public int register(Users user) {
		 List<Users> userList=findUsername(user.getUsername());
		
		 if(userList.size()==0) {
			 userEntityManager.persist(user);
			 userEntityManager.persist(new Authorities(user.getUsername(),"user"));
			 return 1;
		 }
		 else {
			 return 0;
		 }

	
	}

}
