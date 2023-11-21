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
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		@SuppressWarnings("deprecation")
		List<User> users = jdbcTemplate.query(sql, new Object[] { username, password },
				(rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username"), rs.getString("password")));

		if (users.isEmpty()) {
			return "Usuário ou senha incorretos";
		}
		return "Usuário autenticado com sucesso";
	}
}