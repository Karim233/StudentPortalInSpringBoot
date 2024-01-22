package com.example.schoolportalusingspring.binding;

public class DashboardResponse {
    private  Integer totalEnquiry;
    private  Integer enrolledEnquiry;
    private  Integer lostEnquiry;

    public  Integer getTotalEnquiry() {
        return totalEnquiry;
    }

    public void setTotalEnquiry(Integer totalEnquiry) {
        this.totalEnquiry = totalEnquiry;
    }

    public  Integer getEnrolledEnquiry() {
        return enrolledEnquiry;
    }

    public void setEnrolledEnquiry(Integer enrolledEnquiry) {
        this.enrolledEnquiry = enrolledEnquiry;
    }

    public Integer getLostEnquiry() {
        return lostEnquiry;
    }

    public void setLostEnquiry(Integer lostEnquiry) {
        this.lostEnquiry = lostEnquiry;
    }
}

