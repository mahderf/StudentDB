package studentdb.mahi.studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import studentdb.mahi.studentdb.models.Student;
import studentdb.mahi.studentdb.repository.StudentRepo;

import javax.validation.Valid;

@Controller

public class MainController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/")
    public String addInfo(Model model) {
        model.addAttribute("newschool", new Student());
        return "addinfo";
    }

    @PostMapping("/")
    public String postInfo(@Valid @ModelAttribute("newschool") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addinfo";
        }
        studentRepo.save(student);
        return "postinfo";
    }

    @GetMapping("/login")
    public String logon() {
        return "login";
    }

    @GetMapping("/showall")
    public String showAll(Model model, Student student) {
        Iterable<Student> students = studentRepo.findAll();

        model.addAttribute("stud", students);

        return "studentlist";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("newschool", studentRepo.findOne(id));
        return "addinfo";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        studentRepo.delete(id);
        return "redirect:/showall";
    }
}

