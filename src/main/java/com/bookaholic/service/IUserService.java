package com.bookaholic.service;


import com.bookaholic.model.User;

public interface IUserService {


    public User findByUsername(String username);

    public User findById(Long id);

    public User findByEmail(String email);

    public User save(User user);

    public boolean existsByUsername(String username);

    public boolean existsByEmail(String email);

    User login(String username, String password);



}
