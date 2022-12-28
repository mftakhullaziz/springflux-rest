package com.example.reactiveSpringSQLService.repositories;

import com.example.reactiveSpringSQLService.persistence.UsersTRec;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends R2dbcRepository<UsersTRec, Integer> {
}
