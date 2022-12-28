package com.example.reactiveSpringSQLService.controller;

import com.example.reactiveSpringSQLService.payload.UsersRequest;
import com.example.reactiveSpringSQLService.persistence.UsersTRec;
import com.example.reactiveSpringSQLService.service.UsersGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "users")
public class UsersRestController {

    private final UsersGateway gateway;

    public UsersRestController(UsersGateway gateway) {
        this.gateway = gateway;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUsers(@RequestBody UsersRequest request) {
        Mono<UsersTRec> result = gateway.createUsers(request);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getUsers(@PathVariable Integer id) {
        Mono<UsersTRec> result = gateway.getUsers(id);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
