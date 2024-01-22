package com.example.schoolportalusingspring.repo;

import com.example.schoolportalusingspring.entity.StudentInquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInquiryRepo extends JpaRepository<StudentInquiry, Integer> {
    public List<StudentInquiry> findByCid(Integer cid);
}
