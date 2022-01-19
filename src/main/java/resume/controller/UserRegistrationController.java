package resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import resume.controller.dto.UserRegistrationDto;
import resume.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserRegistrationController {

    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bp;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/registration")
    public String showRegistration(){
    return "registration";
    }
    @RequestMapping(value="/registration",method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("user")UserRegistrationDto registrationDto, HttpSession session){
        userService.save(registrationDto);
        registrationDto.setPassword(bp.encode(registrationDto.getPassword()));
        session.setAttribute("message","User Register!");
        return "redirect:/";
    }

}
