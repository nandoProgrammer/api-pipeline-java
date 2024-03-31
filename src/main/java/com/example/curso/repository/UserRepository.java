package com.example.curso.repository;

import com.example.curso.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository
        extends PagingAndSortingRepository<User, Integer>, CrudRepository<User, Integer> {
    public Iterable<User> findByNameContaining(String name);
}
