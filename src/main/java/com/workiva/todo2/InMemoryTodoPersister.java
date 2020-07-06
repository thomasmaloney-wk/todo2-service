package com.workiva.todo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;

import org.apache.thrift.TException;

import todo_transport.v1.Todo;
import todo_transport.v1.TodoQueryParams;
import todo_transport.v1.WError;

/**
 * Horrible anti-pattern singleton-esque persister
 */
public class InMemoryTodoPersister {
    private HashMap<String, Todo> todoStore;

    // horrible anti-pattern sadness
    private static InMemoryTodoPersister instance;

    public static Todo createTodo(Todo todo) {
        todo.id = newId();
        getInstance().todoStore.put(todo.id, todo);
        return todo;
    }

    public static void deleteTodo(String todoId) throws TException, WError {
        if (!getInstance().todoStore.containsKey(todoId)) {
            throw new WError(1,"No such entry with ID: " + todoId);
        }
        getInstance().todoStore.remove(todoId);
    }

    public static List<Todo> queryTodos(TodoQueryParams params) throws TException, WError {
        ArrayList<Todo> results = new ArrayList<>();
        Set<Entry<String, Todo>> entrySet = getInstance().todoStore.entrySet();
        Iterator<Entry<String,Todo>> it = entrySet.iterator();
        while (it.hasNext()) {
            Entry<String, Todo> pair = it.next();
            if (params.includePublic && pair.getValue().isPublic) {
                results.add(pair.getValue());
                continue;
            }
            if (params.includePrivate && !pair.getValue().isPublic) {
                results.add(pair.getValue());
                continue;
            }
            if (params.includeComplete && pair.getValue().isCompleted) {
                results.add(pair.getValue());
                continue;
            }
            if (params.includeIncomplete && !pair.getValue().isCompleted) {
                results.add(pair.getValue());
                continue;
            }
        }
        return results;
    }

    public static Todo updateTodo(Todo todo) throws TException, WError {
        if (todo.id.isEmpty()) {
            throw new WError(2, "Todo ID cannot be empty");
        }
        if (!InMemoryTodoPersister.getInstance().todoStore.containsKey(todo.id)) {
            throw new WError(1,"No such entry with ID: " + todo.id);
        }
        InMemoryTodoPersister.getInstance().todoStore.put(todo.id, todo);
        return todo;
    }

    private static String newId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

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