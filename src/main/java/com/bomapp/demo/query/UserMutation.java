package com.bomapp.demo.query;

import com.bomapp.demo.model.User;
import com.bomapp.demo.service.UserService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User createUser(String login, String name, int departmentId) {
        return this.userService.createUser(login, name, departmentId);
    }

    public User updateUser(int id, String login, String name, int departmentId) {
        return this.userService.updateUser(id, login, name, departmentId);
    }
}
