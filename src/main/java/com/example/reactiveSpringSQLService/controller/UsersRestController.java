package com.example.reactiveSpringSQLService.controller;

import com.example.reactiveSpringSQLService.payload.ResponseDto;
import com.example.reactiveSpringSQLService.payload.Users;
import com.example.reactiveSpringSQLService.payload.UsersRequest;
import com.example.reactiveSpringSQLService.service.UsersGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UsersRestController {

    private final UsersGateway gateway;

    public UsersRestController(UsersGateway gateway) {
        this.gateway = gateway;
    }

    @GetMapping("/get/{id}")
    public Mono<ResponseEntity<ResponseDto<Users>>> getUser(@PathVariable Integer id) {
        Mono<Users> result = gateway.getUsers(id);
        return result.map(
                res -> new ResponseEntity<>(
                        ResponseDto.success(res, RestConstant.ACCEPTED, HttpStatus.OK.value()),
                        HttpStatus.OK)
                ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<ResponseDto<Users>>> createUser(@RequestBody UsersRequest request) {
        Mono<Users> result = gateway.createUsers(request);
        return result.map(
                res -> new ResponseEntity<>(
                        ResponseDto.success(res, RestConstant.CREATED, HttpStatus.CREATED.value()),
                        HttpStatus.OK)
                ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get")
    public Mono<ResponseEntity<ResponseDto<List<Users>>>> getUserAll() {
        Flux<Users> result = gateway.getUsers();
        return result.collectList().map(
               res -> new ResponseEntity<>(
                       ResponseDto.success(res, RestConstant.ACCEPTED, HttpStatus.CREATED.value()),
                       HttpStatus.OK)
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




}
