package com.workiva.todo2;

import com.workiva.frugal.FContext;
import com.workiva.messaging_sdk.exception.IamException;
import com.workiva.messaging_sdk.iam.IamContext;

import todo_transport.v1.*;

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
    private final TodosPublisher.Iface publisher;

    public FTodoServiceHandler(TodosPublisher.Iface publisherClient) {
        publisher = publisherClient;
    }

    @Override
    public Todo createTodo(FContext ctx, Todo todo) throws TException, WError {
        authorize(ctx);
        IamUserInfoTuple iamInfo = getUserInfo(ctx);
        todo.setAccountID(iamInfo.getAccountId());
        todo.setUserID(iamInfo.getUserId());
        InMemoryTodoPersister.createTodo(todo);
        publisher.publishTodoCreated(ctx, iamInfo.getAccountId(), iamInfo.getMembershipId(),todo);
        return null;
    }

    @Override
    public void deleteTodo(FContext ctx, String todoID) throws TException, WError {
        authorize(ctx);
        IamUserInfoTuple iamInfo = getUserInfo(ctx);
        Todo todo = InMemoryTodoPersister.deleteTodo(todoID);
        publisher.publishTodoDeleted(ctx, iamInfo.getAccountId(), iamInfo.getMembershipId(), todo);
    }

    @Override
    public List<Todo> queryTodos(FContext ctx, TodoQueryParams params) throws TException, WError {
        authorize(ctx);
        return InMemoryTodoPersister.queryTodos(params);
    }

    @Override
    public Todo updateTodo(FContext ctx, Todo todo) throws TException, WError {
        authorize(ctx);
        IamUserInfoTuple iamInfo = getUserInfo(ctx);
        InMemoryTodoPersister.updateTodo(todo);
        publisher.publishTodoUpdated(ctx, iamInfo.getAccountId(), iamInfo.getMembershipId(), todo);
        return null;
    }

    protected IamUserInfoTuple getUserInfo(FContext ctx) throws TException {
        try {
            IamContext iam = new IamContext(ctx);
            IamUserInfoTuple ret = new IamUserInfoTuple();
            ret.setUserId(iam.getUserId());
            ret.setAccountId(iam.getAccountId());
            ret.setMembershipId(iam.getMembershipId());
            return ret;
        } catch (IamException ie) {
            TException err = new TException("Invalid IamContext", ie);
            LOG.error("authentication error", err);
            throw err;
        }
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

