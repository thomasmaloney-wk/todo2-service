package com.workiva.todo2;

import com.workiva.frugal.FContext;
import com.workiva.messaging_sdk.exception.IamException;
import com.workiva.messaging_sdk.iam.IamContext;

import todo_transport.v1.FTodoService;
import todo_transport.v1.Todo;
import todo_transport.v1.TodoQueryParams;
import todo_transport.v1.WError;

import org.apache.thrift.TException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A handler that handles all incoming requests to the server, currently stores
 * everything in memory for simplicity
 */
public class FTodoServiceHandler implements FTodoService.Iface {
    private static final Logger LOG = LoggerFactory.getLogger(FTodoServiceHandler.class);

    @Override
    public Todo createTodo(FContext ctx, Todo todo) throws TException, WError {
        authorize(ctx);
        InMemoryTodoPersister.createTodo(todo);
        return null;
    }

    @Override
    public void deleteTodo(FContext ctx, String todoID) throws TException, WError {
        authorize(ctx);
        InMemoryTodoPersister.deleteTodo(todoID);
    }

    @Override
    public List<Todo> queryTodos(FContext ctx, TodoQueryParams params) throws TException, WError {
        authorize(ctx);
        List<Todo> results = InMemoryTodoPersister.queryTodos(params);
        return results;
    }

    @Override
    public Todo updateTodo(FContext ctx, Todo todo) throws TException, WError {
        authorize(ctx);
        InMemoryTodoPersister.updateTodo(todo);
        return null;
    }

    protected void authorize(FContext ctx) throws TException {
        try {
            IamContext iam = new IamContext(ctx);
            if (!hasRoles(iam, new ArrayList<>())) {
                TException err = new TException("Insufficient roles");
                LOG.error("authorize error", err);
                throw err;
            }
        } catch (IamException ie) {
            TException err = new TException("Invalid IamContext", ie);
            LOG.error("authorize error", err);
            throw err;
        }
    }

    private boolean hasRoles(IamContext ctx, List<String> roles) {
        return true; //lmao implying I'm gonna do authorization
    }
}