package com.example.schoolportalusingspring.controller2;

import com.example.schoolportalusingspring.binding.SearchInquiry;
import com.example.schoolportalusingspring.entity.StudentInquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InquiryController {

    @Autowired
    private InquiryService InquiryService;
    //display inquiry page
    @GetMapping("/inquiry")
    public String inquiryPage(Model model) {
        model.addAttribute("Inquiry", new StudentInquiry());
        return "inquiry";
    }

   @PostMapping("/Inquiry")
    public String addInquiry(StudentInquiry studentInquiry, Model model) {
        boolean addInquiry = InquiryService.(studentInquiry);
       if(addInquiry)
           model.addAttribute("message", "Inquiry added successfully");
        return "addInquiryView";
    }

    @GetMapping("/viewInquiry")
    public String viewInquiry(Model model) {
        return "displayInquiryView";
    }

    public String viewInquiries(Model model) {
        InquiryService();
        return "displayInquiryView";
    }
    @GetMapping("/filterInquiry")
    public String fiterInquiry(SearchInquiry searchInquiry, Model model) {
        return "inquiry";
    }
}
