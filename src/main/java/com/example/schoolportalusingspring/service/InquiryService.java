package com.example.schoolportalusingspring.service;

import com.example.schoolportalusingspring.binding.SearchCriteria;
import com.example.schoolportalusingspring.entity.StudentInquiry;

import java.util.List;

public interface InquiryService {
    public boolean addInquiry(StudentInquiry studentInquiry);
    public List<StudentInquiry> getInquiries(Integer cid, SearchCriteria searchCriteria);
}
