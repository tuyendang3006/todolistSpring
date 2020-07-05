package com.polytech.todolist.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.todolist.repository.JpaTaskRepository;
import com.polytech.todolist.repository.JpaUserRepository;
import com.polytech.todolist.repository.TaskRepository;
import com.polytech.todolist.repository.UserRepository;
import com.polytech.todolist.service.RegisterService;
import com.polytech.todolist.service.RegisterServiceImpl;
import com.polytech.todolist.service.TaskService;
import com.polytech.todolist.service.TaskServiceImpl;

@Configuration
public class AppConfig {
	@Bean
    TaskRepository taskRepository() {
        return new JpaTaskRepository(dataSource());
    }
    @Bean
    UserRepository userRepository() {
        return new JpaUserRepository(dataSource());
    }

    @Bean
    DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();

        //dataSource.setURL("jdbc:mysql://www.db4free.net:3306/todolist12345");
        //dataSource.setUser("tuyendang1234");
        //dataSource.setPassword("tuyen1234");
        //dataSource.setDatabaseName("todolist12345");
        //return dataSource;

        dataSource.setURL("jdbc:mysql://localhost:3306/todolist?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("tuyen1994");
        dataSource.setDatabaseName("todolist");
        return dataSource;
        
    }
    
    @Bean
    RegisterService registerService() {
	    return new RegisterServiceImpl(userRepository());
    }
    @Bean
    TaskService taskService() {
	    return new TaskServiceImpl(taskRepository());
    }
    

}

