package org.openapi.users.controller;

import org.openapi.users.api.UsersApi;
import org.openapi.users.model.User;
import org.openapi.users.model.UserRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController implements UsersApi {

    private final Map<Long, User> store = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    // CREATE
    @Override
    public ResponseEntity<User> createUser(UserRequest userRequest) {
        User user = new User();
        user.setId(idGenerator.incrementAndGet());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());

        store.put(user.getId(), user);
        return ResponseEntity.status(201).body(user);
    }

    // READ ALL
    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(new ArrayList<>(store.values()));
    }

    // READ BY ID
    @Override
    public ResponseEntity<User> getUserById(Long id) {
        User user = store.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    // UPDATE
    @Override
    public ResponseEntity<User> updateUser(Long id, UserRequest userRequest) {
        User existing = store.get(id);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        existing.setName(userRequest.getName());
        existing.setEmail(userRequest.getEmail());

        store.put(id, existing);

        return ResponseEntity.ok(existing);
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        if (!store.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        store.remove(id);
        return ResponseEntity.noContent().build();
    }
}
