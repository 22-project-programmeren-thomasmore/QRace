package be.thomasmore.qrace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping("/manageQuestions")
    public String manageQuestions() {
        return "admin/manageQuestions";
    }

//    @RequestMapping("/highScore"){
//        return "/highScore";
//    }
}
