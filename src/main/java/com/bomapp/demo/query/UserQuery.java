package com.bomapp.demo.query;

import com.bomapp.demo.model.User;
import com.bomapp.demo.service.UserService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserQuery implements GraphQLQueryResolver {

    private UserService userService;

    public UserQuery(UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers() {
        return userService.getUsers();
    }

    public List<User> getUserList(int first, int last) {
        System.out.println("Query: [" + first + "] to [" + last + "]");

        if ((first == 0) && (last == 0)) {
            return this.userService.getAllUsers();
        } else {
            return this.userService.getUserList(first, last);
        }
    }

    public Optional<User> getUser(int id) {
        System.out.println("getUser()");
        return this.userService.getUser(id);
    }
}
