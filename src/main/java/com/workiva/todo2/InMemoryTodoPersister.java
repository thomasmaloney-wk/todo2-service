package com.workiva.todo2;

import java.util.HashMap;
import java.util.Map;

import todo_transport.v1.Todo;

/**
 * Horrible antipattern singleton-esque persister
 */
public class InMemoryTodoPersister {
    // leaving this public purely for demo
    public HashMap<String, Todo> todoStore;

    private static InMemoryTodoPersister instance;

    private InMemoryTodoPersister() {
        todoStore = new HashMap<>();
    }

    public static InMemoryTodoPersister getInstance() {
        if (InMemoryTodoPersister.instance == null) {
            InMemoryTodoPersister.instance = new InMemoryTodoPersister();
        }
        return InMemoryTodoPersister.instance;
    }
}