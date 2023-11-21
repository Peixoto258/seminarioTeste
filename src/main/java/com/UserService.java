package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User authenticate(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username"), rs.getString("password")));
        return users.isEmpty() ? null : users.get(0);
    }
}
