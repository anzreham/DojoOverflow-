package com.rhm.demo.controllers;
import com.rhm.demo.models.Answer;
import com.rhm.demo.models.NewQuestion;
import com.rhm.demo.models.Question;
import com.rhm.demo.services.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
 private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }


    @GetMapping("/")
    public String index(Model model) {
        List<Question> questions = mainService.getQuestions();
        model.addAttribute("questions", questions);
        return "home";
    }

    @GetMapping("/new")
    public String New(@ModelAttribute("newQuestion") NewQuestion newQuest) {
        return "newQuestion";
    }

    @PostMapping("/create")
    public String Create(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion,
                         BindingResult result) {
        if(result.hasErrors())
            return "newQuestion";
        this.mainService.createQuestion(newQuestion);
        return "redirect:/";
    }

    @GetMapping("/questions/{id}")
    public String showProduct(@PathVariable("id") Long id, @ModelAttribute("answerobject") Answer answer, Model model) {

        Question question = mainService.getQuestion(id);

        model.addAttribute("question", question);

        return "showQuestion";
    }

    ///questions/answers
    @PostMapping("/questions/answers")
    public String CreateAnswer(@Valid @ModelAttribute("answerobject") Answer answer, BindingResult result) {
        System.out.println("the id" + answer.getId());
        if(result.hasErrors())
            return "showQuestion";
        Answer newAnswer = this.mainService.createAnswer(answer);
        return "redirect:/" ;
    }

}
