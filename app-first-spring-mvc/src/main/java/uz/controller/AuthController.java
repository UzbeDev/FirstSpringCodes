package uz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String regsiter(Model model){
            return "register";
    }
}
