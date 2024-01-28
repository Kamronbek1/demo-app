package com.company.demoapp.repository;

import com.company.demoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// UserRepository
public interface UserRepository extends JpaRepository<User, Long> {
}
