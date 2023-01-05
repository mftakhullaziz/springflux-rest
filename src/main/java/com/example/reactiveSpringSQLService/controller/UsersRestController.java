package com.example.reactiveSpringSQLService.controller;

import com.example.reactiveSpringSQLService.payload.UsersResponse;
import com.example.reactiveSpringSQLService.payload.Users;
import com.example.reactiveSpringSQLService.payload.UsersRequest;
import com.example.reactiveSpringSQLService.persistence.UsersTRec;
import com.example.reactiveSpringSQLService.service.UsersGateway;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "users")
@Api(tags = "User Rest API")
public class UsersRestController {

    private final UsersGateway gateway;

    public UsersRestController(UsersGateway gateway) {
        this.gateway = gateway;
    }

    @GetMapping("/get/{id}")
    public Mono<ResponseEntity<UsersResponse<Users>>> getUser(@PathVariable Integer id) {
        Mono<Users> result = gateway.getUsers(id);
        return result.map(
               res -> new ResponseEntity<>(
                        UsersResponse.success(res, RestConstant.ACCEPTED, HttpStatus.OK.value()),
                        HttpStatus.OK)
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<UsersResponse<Users>>> createUser(@RequestBody UsersRequest request) {
        Mono<Users> result = gateway.createUsers(request);
        return result.map(
               res -> new ResponseEntity<>(
                        UsersResponse.success(res, RestConstant.CREATED, HttpStatus.CREATED.value()),
                        HttpStatus.OK)
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get")
    public Mono<ResponseEntity<UsersResponse<List<Users>>>> getUserAll() {
        Flux<Users> result = gateway.getUsers();
        return result.collectList().map(
               res -> new ResponseEntity<>(
                       UsersResponse.success(res, RestConstant.ACCEPTED, HttpStatus.CREATED.value()),
                       HttpStatus.OK)
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/update/{id}")
    public Mono<ResponseEntity<UsersResponse<Users>>> updateUser(@RequestBody UsersRequest request, @PathVariable Integer id) {
        Mono<Users> result = gateway.updateUsers(id, request);
        return result.map(
               res -> new ResponseEntity<>(
                        UsersResponse.success(res, RestConstant.CREATED, HttpStatus.CREATED.value()),
                        HttpStatus.OK)
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<UsersTRec> deleteUser(@PathVariable Integer id) {
        return gateway.deleteUsers(id);
    }

}
