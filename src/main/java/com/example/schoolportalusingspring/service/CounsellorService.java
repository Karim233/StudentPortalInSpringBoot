package com.example.schoolportalusingspring.service;


import com.example.schoolportalusingspring.binding.DashboardResponse;
import com.example.schoolportalusingspring.entity.Counsellor;

public interface CounsellorService {
    public String saveCounsellor(Counsellor counsellor);
    public Counsellor loginCheck(String email, String password );
    public boolean recoverPassword(String email);

    public DashboardResponse getDashboardInfo(Integer cid);
}

