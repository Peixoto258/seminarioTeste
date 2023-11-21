package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            return "Usuário autenticado: " + user.getUsername();
        } else {
            return "Senha errada!"; //Enumeração de Usuário
        }
    }
}