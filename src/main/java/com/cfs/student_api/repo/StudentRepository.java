package com.cfs.student_api.repo;

import com.cfs.student_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//repo layer -> ye database se baat krega
public interface StudentRepository extends JpaRepository<Student,Long> {
}
