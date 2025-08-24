package ru.netology.order;

import java.util.List;

public record Order(
        Long id,
        Long userId,
        Double amount,
        String currency,
        List<String> items
) {}