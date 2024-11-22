package com.Token.JWT_Token.repository;

import com.Token.JWT_Token.Entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Register,Long> {
}
