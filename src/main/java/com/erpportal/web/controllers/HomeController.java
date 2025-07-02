package com.erpportal.web.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(HttpSession session) {
        // Eğer oturumda WorkCenter seçiliyse Operasyon listesine gönder; değilse login'e.
        String workCenterCode = (String) session.getAttribute("WorkCenterCode");
        if (workCenterCode == null || workCenterCode.isEmpty()) {
            return "redirect:/login";
        }
        return "redirect:/operations";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
} 