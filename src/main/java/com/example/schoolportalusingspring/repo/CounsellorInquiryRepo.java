package com.example.schoolportalusingspring.repo;

import com.example.schoolportalusingspring.binding.DashboardResponse;
import com.example.schoolportalusingspring.entity.Counsellor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounsellorInquiryRepo extends JpaRepository<Counsellor, Integer> {
    public Counsellor findByEmail(String email);
    public Counsellor findByEmailAndPassword(String email , String password);

}
