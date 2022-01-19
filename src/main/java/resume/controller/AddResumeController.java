package resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddResumeController {

    @GetMapping("/create")
    public String createResume(Model model){
       return "createResume";
    }
}
