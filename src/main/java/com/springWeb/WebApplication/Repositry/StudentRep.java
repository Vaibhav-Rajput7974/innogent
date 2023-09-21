package com.springWeb.WebApplication.Repositry;

import com.springWeb.WebApplication.Entity.College;
import com.springWeb.WebApplication.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRep extends JpaRepository<Student,Long> {
    @Transactional
    void deleteByCollegeId(long collegeId);
    @Transactional
    List<Student> findByCollegeId(int collegeId);
}
