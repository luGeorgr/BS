package www.george.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserProgressControll {

    @RequestMapping(value = "Progress", method = RequestMethod.GET)
    public String getProgress(@PathVariable("lexicon") String bookName,
                              ModelMap model){
        model.addAttribute("", "");
        return "user";
    }
}
