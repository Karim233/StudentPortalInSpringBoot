package com.example.schoolportalusingspring.controller;


import com.example.schoolportalusingspring.binding.DashboardResponse;
import com.example.schoolportalusingspring.entity.Counsellor;
import com.example.schoolportalusingspring.entity.StudentInquiry;
import com.example.schoolportalusingspring.service.CounsellorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Controller should talk to thw service layer
@Controller
public class CounsellorController {


    @Autowired
    private CounsellorService counsellorService;

    @GetMapping("/logout")
    public String logout(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession(false);
        session.invalidate();
        return "redirect:/";
    }
    //Display login page , when the login form is submitted, data come to the empty counsellor object
   @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("counsellor", new Counsellor());
        return "loginView";
    }
//handle the login
    @PostMapping ("/login")
    public String handleLogin(Counsellor counsellor, HttpServletRequest req , Model model) {
        Counsellor obj = counsellorService.loginCheck(counsellor.getEmail(), counsellor.getPassword());
        if (obj == null) {
            model.addAttribute("errorMessage", "Invalid Email or Password");
            return "loginView";
        }
            HttpSession session = req.getSession(true);
               session.setAttribute("CID", obj.getCid());
            //redirect to dashboard
            return "redirect:/dashboard";
        }

        @GetMapping("/register")
     public String registrationPage(Model model) {
        model.addAttribute("counsellor", new Counsellor());
        return "registrationView";
    }

    @GetMapping("/dashboard")
    public String buildDashBoard(HttpServletRequest req, Model model) {
       HttpSession session = req.getSession(false);
       Object obj = session.getAttribute("cid");
       Integer cid = (Integer) obj;
   DashboardResponse dashboardInformation = counsellorService.getDashboardInfo(cid);
   model.addAttribute("dashboard", dashboardInformation);
       return "dashboardView";
    }
    @PostMapping("/register")
    public String handleRegistration(Counsellor counsellor , Model model) {

        String message = counsellorService.saveCounsellor(counsellor);
        model.addAttribute("message", message);
        return "registrationView";
    }
    @GetMapping("/forgot-Password")
    public String recoverPasswordPage(Model model) {
        //model.addAttribute("counsellor", new Counsellor());
        return "forgotPasswordView";
    }
    @GetMapping("/recover-pwd")
    public String recoverPwd(@RequestParam String email, Model model) {
        boolean status = counsellorService.recoverPassword(email);
        if (status) {
            model.addAttribute("sentMessage", "Pwd sent to your email");
        } else {
            model.addAttribute("errMessage", "Invalid Email");
        }
        return "forgotPasswordView";
    }

}