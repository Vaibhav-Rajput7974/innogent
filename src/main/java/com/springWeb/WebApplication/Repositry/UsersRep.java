package com.springWeb.WebApplication.Repositry;

import com.springWeb.WebApplication.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRep extends JpaRepository<Users,Long> {
    @Transactional
    Users findByEmail(String email);
}
