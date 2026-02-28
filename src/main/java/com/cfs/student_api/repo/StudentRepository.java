package com.cfs.student_api.repo;

import com.cfs.student_api.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//repo layer -> ye database se baat krega
public interface StudentRepository extends JpaRepository<Student,Long> {

    Page<Student> findByNameContaining(String name, Pageable pageable);     //filtering ka logic repo me kyoki filtering DB level pe hoti h
}
