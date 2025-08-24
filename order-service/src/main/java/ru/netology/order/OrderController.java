package ru.netology.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    private final Map<Long, List<Order>> ordersByUser = Map.of(
            1L, List.of(
                    new Order(101L, 1L, 1200.0, "RUB", List.of("Ноутбук", "Мышь")),
                    new Order(102L, 1L, 500.0, "RUB", List.of("Клавиатура"))
            ),
            2L, List.of(
                    new Order(201L, 2L, 300.0, "RUB", List.of("Флешка", "Наушники"))
            )
    );

    @GetMapping("/api/orders/by-user/{user}")
    public List<Order> getOrdersByUser(@PathVariable Long user) {
        return ordersByUser.getOrDefault(user, List.of());
    }
}
