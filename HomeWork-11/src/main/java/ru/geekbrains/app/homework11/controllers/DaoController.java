package ru.geekbrains.app.homework11.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.app.homework11.entities.User;
import ru.geekbrains.app.homework11.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class DaoController {

    private final UserService userService;

    @GetMapping
    public String TestPage(Principal principal){
        try {
            User user = userService.findUserByUserName(principal.getName()).orElseThrow(() -> new NullPointerException("Надо авторизоваться"));
            return "Привет " + user.getUsername();
        } catch (NullPointerException e) {
            return "Для выполнения команд необходимо <a href = \"login\"> авторизоваться </a>";
        }
    }

    @GetMapping("/app/score/get/current")
    public String getBall(Principal principal) {
        try {
        User user = userService.findUserByUserName(principal.getName()).orElseThrow(() -> new NullPointerException("Надо авторизоваться"));
        return "У пользователя " + user.getUsername() + " " + user.getScore() + " баллов";
        } catch (NullPointerException e) {
            //return ("Пользователь не авторизован");
            return "для выполнения запроса необходимо <a href = \"login\"> авторизоваться </a>";
        }
    }

    @GetMapping("/app/score/dec")
    public String decBall(Principal principal) {
        try {
            User user = userService.findUserByUserName(principal.getName()).orElseThrow(() -> new NullPointerException("Надо авторизоваться"));
            userService.decBall(user);
            return "У пользователя " + user.getUsername() + " " + user.getScore() + " баллов";
        } catch (NullPointerException e) {
            return "для выполнения запроса необходимо <a href = \"login\"> авторизоваться </a>";
        }
    }

    @GetMapping("/app/score/inc")
    public String incBall(Principal principal) {
        try {
            User user = userService.findUserByUserName(principal.getName()).orElseThrow(() -> new NullPointerException("Надо авторизоваться"));
            userService.incBall(user);
            return "У пользователя " + user.getUsername() + " " + user.getScore() + " баллов";
        } catch (NullPointerException e) {
            return "для выполнения запроса необходимо <a href = \"login\"> авторизоваться </a>";
        }
    }

    @GetMapping("/app/score/get/{id}")
    public String getBallById(@PathVariable Long id) {
        try {
            User user = userService.findUserByUserId(id).orElseThrow(() -> new NullPointerException("Пользователя с id " + id + " не найдено"));
            return "У пользователя " + user.getUsername() + " " + user.getScore() + " баллов";
        } catch (NullPointerException e) {
            return e.getMessage();
        }
    }
}
