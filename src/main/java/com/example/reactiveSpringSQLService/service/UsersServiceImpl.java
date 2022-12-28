package com.example.reactiveSpringSQLService.service;

import com.example.reactiveSpringSQLService.payload.UsersRequest;
import com.example.reactiveSpringSQLService.persistence.UsersTRec;
import com.example.reactiveSpringSQLService.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class UsersServiceImpl implements UsersGateway{

    private final UsersRepository repository;

    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    private final DateTimeFormatter patternDateTime = DateTimeFormatter.ofPattern("yyyyMMdd");
    private final LocalDateTime dateTime = LocalDateTime.now();

    @Override
    public Mono<UsersTRec> createUsers(UsersRequest request) {
        return repository.save(constructBuild(request));
    }

    private UsersTRec constructBuild(UsersRequest request) {
        return UsersTRec.builder().email(request.getEmail()).name(request.getName()).
                username(request.getUsername()).phone(request.getPhoneNumber()).
                dateIndex(Integer.valueOf(patternDateTime.format(dateTime))).build();
    }

    @Override
    public Mono<UsersTRec> getUsers(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Flux<UsersTRec> getUsers() {
        return null;
    }

    @Override
    public Flux<UsersTRec> getUsersByDateIndex(Integer startDate, Integer endDate) {
        return null;
    }

    @Override
    public Mono<UsersTRec> deleteUsers(Integer id) {
        return null;
    }
}
