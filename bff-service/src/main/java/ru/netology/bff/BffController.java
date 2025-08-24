package ru.netology.bff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BffController {

    private final BffService bffService;

    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    @GetMapping("/api/site-bff/user/{userId}")
    public Mono<UserProfile> getUserProfile(@PathVariable Long userId) {
        return bffService.getUserProfile(userId);
    }
}