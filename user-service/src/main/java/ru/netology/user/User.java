package ru.netology.user;

public record User(
        Long id,
        String fullName,
        String address,
        String phone,
        String email
) {}