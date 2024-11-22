package com.Token.JWT_Token.repository;

import com.Token.JWT_Token.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     *
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}