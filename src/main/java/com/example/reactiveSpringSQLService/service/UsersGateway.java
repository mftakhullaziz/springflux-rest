package com.example.reactiveSpringSQLService.service;

import com.example.reactiveSpringSQLService.payload.Users;
import com.example.reactiveSpringSQLService.payload.UsersRequest;
import com.example.reactiveSpringSQLService.persistence.UsersTRec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsersGateway {
    Mono<Users> createUsers(UsersRequest request);
    Mono<Users> getUsers(Integer id);
    Flux<Users> getUsers();
    Flux<UsersTRec> getUsersByDateIndex(Integer startDate, Integer endDate);
    Mono<UsersTRec> deleteUsers(Integer id);
}
