package com.example.reactiveSpringSQLService.service;

import com.example.reactiveSpringSQLService.payload.UsersRequest;
import com.example.reactiveSpringSQLService.persistence.UsersTRec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsersGateway {
    Mono<UsersTRec> createUsers(UsersRequest request);
    Mono<UsersTRec> getUsers(Integer id);
    Flux<UsersTRec> getUsers();
    Flux<UsersTRec> getUsersByDateIndex(Integer startDate, Integer endDate);
    Mono<UsersTRec> deleteUsers(Integer id);
}
