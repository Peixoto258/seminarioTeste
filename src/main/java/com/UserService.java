package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String authenticate(String username, String password) {
        // Primeiro verifica se o usuário existe (vulnerável a SQL Injection)
        String userSql = "SELECT * FROM user WHERE username = '" + username + "'";
        List<User> users = jdbcTemplate.query(userSql, 
            (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username"), rs.getString("password")));

        if (users.isEmpty()) {
            return "Usuário não encontrado";
        }

        // Se o usuário existe, verifica a senha (também vulnerável a SQL Injection)
        String passwordSql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        List<User> validUsers = jdbcTemplate.query(passwordSql, 
            (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username"), rs.getString("password")));

        if (validUsers.isEmpty()) {
            return "Senha incorreta";
        }

        return "Usuário autenticado com sucesso!";
    }
}