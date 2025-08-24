package ru.netology.bff;

import java.util.List;

public record UserProfile(
        User user,
        List<Order> orders
) {}

record User(
        Long id,
        String fullName,
        String address,
        String phone,
        String email
) {}

record Order(
        Long id,
        Long userId,
        Double amount,
        String currency,
        List<String> items
) {}
