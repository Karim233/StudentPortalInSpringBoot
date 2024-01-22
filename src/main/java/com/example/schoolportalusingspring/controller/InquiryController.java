package com.example.schoolportalusingspring.controller;


import com.example.schoolportalusingspring.binding.SearchCriteria;
import com.example.schoolportalusingspring.entity.StudentInquiry;
import com.example.schoolportalusingspring.service.InquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class InquiryController {

    @Autowired
    private InquiryService inquiryService ;

    //display inquiry page
    @GetMapping("/inquiry")
    public String inquiryPage(Model model) {
        model.addAttribute("inq", new StudentInquiry());
        return "addInquiryView";
    }

    @PostMapping("/inquiry")
    public String addEnquiry(@ModelAttribute("inq") StudentInquiry inq, HttpServletRequest req, Model model) {

        HttpSession session = req.getSession(false);
        Integer cid = (Integer) session.getAttribute("CID");

        if (cid == null) {
            return "redirect:/logout";
        }

        inq.setCid(cid);

        boolean addEnq = inquiryService.addInquiry(inq);
        if (addEnq) {
            model.addAttribute("successMessage", "Enquiry Added");
        } else {
            model.addAttribute("errorMessage", "Enquiry Failed To Add");
        }
        return "addInquiryView";
    }

//    @GetMapping("/viewInquiry")
//    public String viewInquiry(Model model) {
//        return "displayInquiryView";
//    }
    @GetMapping("/inquiries")
    public String viewEnquiries(HttpServletRequest req, Model model) {

        HttpSession session = req.getSession(false);
        Integer cid = (Integer) session.getAttribute("CID");

        if (cid == null) {
            return "redirect:/logout";
        }

        model.addAttribute("sc", new SearchCriteria());

        List<StudentInquiry> enquiriesList = inquiryService.getInquiries(cid, new SearchCriteria());
        model.addAttribute("inquiries", enquiriesList);

        return "displayInquiryView";
    }

//    @PostMapping("/filter-Inquiries")
//    public String filterInquiry(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, HttpServletRequest req, Model model) {
//        HttpSession session = req.getSession(false);
//        Integer cid = (Integer) session.getAttribute("CID");
//        List<StudentInquiry> enquirieslist = inquiryService.getInquiries(cid, searchCriteria);
//        model.addAttribute("enquiries", enquirieslist);
//        return "displayInquiryView";
//    }

    @PostMapping("/filter-enquiries")
    public String filterEnquiries(@ModelAttribute("sc") SearchCriteria searchCriteria, HttpServletRequest req, Model model) {

        HttpSession session = req.getSession(false);
        Integer cid = (Integer) session.getAttribute("CID");

        if (cid == null) {
            return "redirect:/";
        }

        List<StudentInquiry> enquiriesList = inquiryService.getInquiries(cid, searchCriteria);

        model.addAttribute("inquiries", enquiriesList);

        return "filterEnqView";
    }

}

