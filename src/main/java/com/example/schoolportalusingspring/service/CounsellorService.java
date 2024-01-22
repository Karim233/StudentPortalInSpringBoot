package com.example.schoolportalusingspring.service;

import com.example.schoolportalusingspring.binding.DashBoardResponse;
import com.example.schoolportalusingspring.entity.Counsellor;

public interface CounsellorInterface {
    public String saveCounsellor(Counsellor counsellor);
    public Counsellor loginCheck(String email, String password );
    public boolean recoverPassword(String email);
    public DashBoardResponse getDashBoardInfo(Integer id);
}

