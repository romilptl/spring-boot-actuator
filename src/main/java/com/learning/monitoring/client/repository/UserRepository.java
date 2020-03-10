package com.learning.monitoring.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.monitoring.client.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
