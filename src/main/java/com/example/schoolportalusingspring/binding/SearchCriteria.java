package com.example.schoolportalusingspring.binding;

public class SearchCriteria {
    private String CourseName;

    private String ClassMode;

    private String inquiryStatus;



    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }
    public String getCourseName() {
        return CourseName;
    }
    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getClassMode() {
        return ClassMode;
    }

    public void setClassMode(String classMode) {
        ClassMode = classMode;
    }
}

