package com.example.schoolportalusingspring.service;

import com.example.schoolportalusingspring.binding.DashboardResponse;
import com.example.schoolportalusingspring.entity.Counsellor;
import com.example.schoolportalusingspring.entity.StudentInquiry;
import com.example.schoolportalusingspring.repo.CounsellorInquiryRepo;
import com.example.schoolportalusingspring.repo.StudentInquiryRepo;
import com.example.schoolportalusingspring.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CounsellorServiceImplementation implements CounsellorService {

    @Autowired
    private CounsellorInquiryRepo counsellorRepository;
    @Autowired
    private EmailUtils emailUtils;

    @Autowired
    private StudentInquiryRepo studentInquiryRepo;

    @Override
    public String saveCounsellor(Counsellor counsellor) {
        Counsellor obj = counsellorRepository.findByEmail(counsellor.getEmail());
        if (obj != null) {
            return "Email already exists";
        }
        Counsellor savedObj = counsellorRepository.save(counsellor);
        if (savedObj.getCid() != null) {
            return "Registration successful";
        }
        return "Registration failed";
    }

    @Override
    public Counsellor loginCheck(String email, String password) {
        return counsellorRepository.findByEmailAndPassword(email, password);

    }

    @Override
    public boolean recoverPassword(String email) {
        Counsellor c = counsellorRepository.findByEmail(email);
        if (c == null) {
            return false;
        }

        String subject = "Password Recovery";
        String body = "<h1>Your password is: " + c.getPassword() + "</h1>";

        return emailUtils.sendEmail(email, subject, body);

    }

    @Override
    public DashboardResponse getDashboardInfo(Integer cid) {
        List<StudentInquiry>  allInqs = studentInquiryRepo.findByCid(cid);
        int enrolledEns = allInqs
                .stream()
                .filter(i -> i.getInquiryStatus().equals("Enrolled")).toList().size();
        DashboardResponse response = new DashboardResponse();
        response.setTotalEnquiry(allInqs.size());
        response.setEnrolledEnquiry(enrolledEns);
        response.setLostEnquiry(allInqs.size() - enrolledEns);

        return response;
    }
}


