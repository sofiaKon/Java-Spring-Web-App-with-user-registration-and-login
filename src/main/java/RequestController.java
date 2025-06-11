package com.example.loginform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequestController {

    private final UserManager userManager = new UserManager();


    //LoginController
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password) {
        boolean success = userManager.loginUser(username, password);
        if (success) {
            return "redirect:/welcome";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }


    //RegistrationController
    @GetMapping("/registrator")
    public String showRegistratorForm() {
        return "registrator";
    }

    @PostMapping("/registrator")
    public String processRegistration(@RequestParam String username,
                                      @RequestParam String email,
                                      @RequestParam String password) {

        boolean success = userManager.registerUsers(username, email, password);

        if (success) {
            return "redirect:/login";
        } else {
            return "redirect:/registration?error";
        }
    }


    //Смена пароля
    @PostMapping("/changePassword")
    public String changePasswordController (@RequestParam String username,
                                            @RequestParam String password,
                                            @RequestParam String newPassword){
        boolean success = userManager.registerUsers(username, password, newPassword);

        if (success) {
            return "redirect:/changePassword";
        } else {
            return "redirect:/changePassword?error";
        }
    }
}
