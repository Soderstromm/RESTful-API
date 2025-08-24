package ru.netology.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    private final Map<Long, User> users = Map.of(
            1L, new User(1L, "Иван Иванов", "Москва, ул. Ленина, 1", "+79001234567", "ivan@example.com"),
            2L, new User(2L, "Анна Петрова", "СПб, Невский пр., 10", "+79007654321", "anna@example.com")
    );

    @GetMapping("/api/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        return users.get(userId);
    }
}
