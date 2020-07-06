package com.workiva.todo2;

import com.workiva.frugal.FContext;
import todo_transport.v1.FTodoService;
import todo_transport.v1.Todo;
import todo_transport.v1.TodoQueryParams;
import todo_transport.v1.WError;

import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A handler that handles all incoming requests to the server Currently stores
 * everything in memory for simplicity
 */
public class FTodoServiceHandler implements FTodoService.Iface {

    @Override
    public Todo createTodo(FContext ctx, Todo todo) throws TException, WError {
        todo.id = newId();
        InMemoryTodoPersister.getInstance().todoStore.put(todo.id, todo);
        return null;
    }

    @Override
    public void deleteTodo(FContext ctx, String todoID) throws TException, WError {
        if (!InMemoryTodoPersister.getInstance().todoStore.containsKey(todoID)) {
            throw new WError(1,"No such entry with ID: " + todoID);
        }
        InMemoryTodoPersister.getInstance().todoStore.remove(todoID);
    }

    @Override
    public List<Todo> queryTodos(FContext ctx, TodoQueryParams params) throws TException, WError {
        ArrayList<Todo> results = new ArrayList<>();
        Set<Entry<String, Todo>> entrySet = InMemoryTodoPersister.getInstance().todoStore.entrySet();
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

    @Override
    public Todo updateTodo(FContext ctx, Todo todo) throws TException, WError {
        if (todo.id.isEmpty()) {
            throw new WError(2, "Todo ID cannot be empty");
        }
        if (!InMemoryTodoPersister.getInstance().todoStore.containsKey(todo.id)) {
            throw new WError(1,"No such entry with ID: " + todo.id);
        }
        InMemoryTodoPersister.getInstance().todoStore.put(todo.id, todo);
        return null;
    }

    private String newId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
    
}