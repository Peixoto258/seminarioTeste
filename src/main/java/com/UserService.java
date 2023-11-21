package com;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public String authenticate(String username, String password) {
    	logger.info("****************************************************");
    	logger.info("Data: "+ LocalDate.now()+"; username = " + username);
    	logger.info("Data: "+ LocalDate.now()+"; password = " + password);
    	logger.info("****************************************************");
    	
        String userSql = "SELECT * FROM user WHERE username = '" + username + "'";
        List<User> users = jdbcTemplate.query(userSql, 
            (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username"), rs.getString("password")));

        if (users.isEmpty()) {
            return "Usuário não encontrado";
        }

        String passwordSql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        List<User> validUsers = jdbcTemplate.query(passwordSql, 
            (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username"), rs.getString("password")));

        if (validUsers.isEmpty()) {
            return "Senha incorreta";
        }

        return "Usuário autenticado com sucesso!";
    }
}