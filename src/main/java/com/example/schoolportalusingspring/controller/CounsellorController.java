package com.example.schoolportalusingspring.controller2;

import com.example.schoolportalusingspring.entity.Counsellor;
import com.example.schoolportalusingspring.service.CounsellorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;
@Controller
public class CounsellorController {

    @Autowired
    private CounsellorService counsellorService;
   @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("counsellor", new Counsellor());
        return "loginView";
    }
    @GetMapping ("/login")
    public String handleLogin(Counsellor counsellor, Model model) {
        Counsellor obj = counsellorService.loginCheck(counsellor.getEmail(), counsellor.getPassword());
        if (obj == null) {
            model.addAttribute("errorMessage", "Invalid Email or Password");
            return "loginView";
        }
            return "dashboardView";
        }
      @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("counsellor", new Counsellor());
        return "registrationView";
    }

    @GetMapping("/dashboard")
    public String buildDashBoard( Model model) {
       //get data for dashboard
//        DashBoardResponse response = counsellorService.getDashBoardInfo(1);
//        model.addAttribute("response", response);
       return "dashboardView";
    }
    @GetMapping("/register")
    public String handleRegistration(Counsellor counsellor , Model model) {

        String message = counsellorService.saveCounsellor(counsellor);
        model.addAttribute("message", message);
        return "registrationView";
    }
    @GetMapping("/forgot Password")
    public String recoverPasswordPage(Model model) {
        //model.addAttribute("counsellor", new Counsellor());
        return "forgotPasswordView";
    }
    @GetMapping("/recoverPassword")
    public String rcoverPassword(String email, Model model) {
       boolean status = counsellorService.recoverPassword(email);
       if (status) {
           model.addAttribute("message", "Password sent to your email");
       } else {
           model.addAttribute("message", "Invalid Email");
       }
       return "forgotPasswordView";






















    }
}
