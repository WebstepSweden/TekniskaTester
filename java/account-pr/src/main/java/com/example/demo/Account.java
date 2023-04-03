package com.example.demo;

import org.springframework.lang.NonNull;

import java.util.UUID;

public class Account {
    private final UUID id;
    private final String name;

    public Account(@NonNull final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }

    @NonNull
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
