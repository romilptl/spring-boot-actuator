package com.learning.monitoring.client.service;

import org.springframework.stereotype.Service;

import com.learning.monitoring.client.modal.User;
import com.learning.monitoring.client.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();    
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    
}

