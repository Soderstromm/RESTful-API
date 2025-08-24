package ru.netology.bff;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
public class BffService {

    private final WebClient userClient;
    private final WebClient orderClient;

    public BffService(WebClient.Builder webClientBuilder) {
        this.userClient = webClientBuilder.build();
        this.orderClient = webClientBuilder.build();
    }

    public Mono<UserProfile> getUserProfile(Long userId) {
        Mono<User> userMono = userClient.get()
                .uri("http://localhost:8881/api/users/" + userId)
                .retrieve()
                .bodyToMono(User.class)
                .onErrorReturn(new User(null, "User not found", "", "", ""));

        Mono<List<Order>> ordersMono = orderClient.get()
                .uri("http://localhost:8882/api/orders/by-user/" + userId)
                .retrieve()
                .bodyToFlux(Order.class)
                .collectList()
                .onErrorReturn(Collections.emptyList());

        return Mono.zip(userMono, ordersMono)
                .map(tuple -> new UserProfile(tuple.getT1(), tuple.getT2()));
    }
}
