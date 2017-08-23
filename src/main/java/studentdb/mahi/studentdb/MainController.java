package studentdb.mahi.studentdb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller

public class MainController {
    @Controller
    public class HomeController {
        @GetMapping("/addinfo")
        public String addInfo(Model model){
            model.addAttribute("newschool", new Student());
            return"addinfo";
        }
        @PostMapping("/addinfo")
        public String postInfo(@Valid @ModelAttribute("newschool")BindingResult bindingResult){
            if(bindingResult.hasErrors()){
                return "addinfo";
            }
            return "postinfo";
        }
        @GetMapping("/login")
        public String logon(){
            return"login";
        }
    }

}
