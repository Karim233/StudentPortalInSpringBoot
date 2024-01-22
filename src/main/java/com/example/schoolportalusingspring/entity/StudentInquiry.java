package com.example.schoolportalusingspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class StudentInquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enquiryId;
    private String name;
    private String phone;
    private String classMode;
    private String courseName;
    private String inquiryStatus;
    private LocalDate CREATED_DATE;
    private Integer cid;

    public Integer getInquiryId() {
        return enquiryId;
    }

    public void setInquiryId(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassMode() {
        return classMode;
    }

    public void setClassMode(String classMode) {
        this.classMode = classMode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    public LocalDate getCREATED_DATE() {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(LocalDate CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}



