package com;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SeminarioTesteSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeminarioTesteSoftwareApplication.class, args);
	}
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initializeDatabase() {
        jdbcTemplate.execute(
            "CREATE TABLE IF NOT EXISTS user (" +
            "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
            "username VARCHAR(255), " +
            "password VARCHAR(255))"
        );
        
        jdbcTemplate.update("INSERT INTO user (username, password) VALUES (?, ?)", "user1", "pass1");
        jdbcTemplate.update("INSERT INTO user (username, password) VALUES (?, ?)", "user2", "pass2");
        jdbcTemplate.update("INSERT INTO user (username, password) VALUES (?, ?)", "admin", "admin");
    
    }

}
