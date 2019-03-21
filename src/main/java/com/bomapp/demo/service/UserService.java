package com.bomapp.demo.service;

import com.bomapp.demo.model.User;
import com.bomapp.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository db) {
        this.userRepository = db;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return this.userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserList(int first, int last) {
        if ((last == 0) || last < first) {
            last = (int)this.userRepository.count();
        }

        return this.userRepository.findAllById(
                IntStream.rangeClosed(first, last)
                .boxed()
                .collect(Collectors.toList())
        );
    }

    public User createUser(String login, String name, int departmentId) {
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setDepartmentId(departmentId);

        return this.userRepository.save(user);
    }

    public User updateUser(int id, String login, String name, int departmentId) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setLogin(login);
            user.get().setName(name);
            user.get().setDepartmentId(departmentId);
        }

        return userRepository.save(user.get());
    }

    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }
}
