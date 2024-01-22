package com.example.schoolportalusingspring.service;

import com.example.schoolportalusingspring.binding.SearchCriteria;
import com.example.schoolportalusingspring.entity.StudentInquiry;
import com.example.schoolportalusingspring.repo.StudentInquiryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImplementation implements InquiryService{

    @Autowired
    private StudentInquiryRepo studentInquiryRepo;
    @Override
    public boolean addInquiry(StudentInquiry studentInquiry) {
      StudentInquiry savedInquiry   = studentInquiryRepo.save(studentInquiry);
        return savedInquiry.getCid() != null;
    }

    @Override
    public List<StudentInquiry> getInquiries(Integer cid, SearchCriteria searchCriteria) {
        StudentInquiry enq = new StudentInquiry();

        //setting cid
        enq.setCid(cid);

        // if mode selected add to query
        if(searchCriteria.getClassMode()!=null && !searchCriteria.getClassMode().isEmpty()) {
            enq.setClassMode(searchCriteria.getClassMode());
        }

        if(searchCriteria.getCourseName()!=null && !searchCriteria.getCourseName().isEmpty()) {
            enq.setCourseName(searchCriteria.getCourseName());
        }

        if(searchCriteria.getInquiryStatus()!=null && !searchCriteria.getInquiryStatus().isEmpty()) {
            enq.setInquiryStatus(searchCriteria.getInquiryStatus());
        }

        Example<StudentInquiry> of = Example.of(enq);

        List<StudentInquiry> enquiries;
        enquiries = studentInquiryRepo.findAll(of);

        return enquiries;
    }

}