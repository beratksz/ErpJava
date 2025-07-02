package com.erpportal.web.controllers;

import com.erpportal.application.interfaces.IUserService;
import com.erpportal.domain.entities.User;
import com.erpportal.domain.entities.WorkCenter;
import com.erpportal.web.models.LoginViewModel;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/account")
public class AuthController {

    private final IUserService userService;

    @Autowired
    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout,
                       Model model) {
        if (error != null) {
            model.addAttribute("error", "Geçersiz kullanıcı adı veya şifre!");
        }
        if (logout != null) {
            model.addAttribute("message", "Başarıyla çıkış yaptınız.");
        }
        
        model.addAttribute("loginModel", new LoginViewModel());
        return "account/login";
    }

    @PostMapping("/authenticate")
    public String authenticate(@ModelAttribute LoginViewModel loginModel, 
                             HttpSession session, 
                             Model model) {
        Optional<User> user = userService.authenticate(loginModel.getUsername(), loginModel.getPassword());
        
        if (user.isEmpty()) {
            model.addAttribute("error", "Geçersiz kullanıcı adı veya şifre!");
            return "account/login";
        }

        // Store user info in session
        session.setAttribute("UserId", user.get().getId());
        session.setAttribute("Username", user.get().getUsername());
        session.setAttribute("FullName", user.get().getFullName());
        session.setAttribute("IsAdmin", user.get().getIsAdmin());

        // Get user's work centers
        List<WorkCenter> workCenters = userService.getUserWorkCenters(user.get().getId());
        
        if (workCenters.size() == 1) {
            // User has only one work center, auto-select it
            session.setAttribute("WorkCenterCode", workCenters.get(0).getCode());
            return "redirect:/";
        } else if (workCenters.size() > 1) {
            // User has multiple work centers, let them choose
            model.addAttribute("workCenters", workCenters);
            return "account/select-work-center";
        } else {
            // User has no work centers assigned
            model.addAttribute("error", "Kullanıcınıza iş merkezi atanmamış. Lütfen yöneticinizle iletişime geçin.");
            return "account/login";
        }
    }

    @PostMapping("/select-work-center")
    public String selectWorkCenter(@RequestParam String workCenterCode, HttpSession session) {
        session.setAttribute("WorkCenterCode", workCenterCode);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/account/login?logout=true";
    }
} 