package www.george.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import www.george.com.service.SignUpService;

@Controller
public class AccountController {
    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/account/{email}", method = RequestMethod.GET)
    public ModelAndView activeAccount(@PathVariable("email") String account){
        account += ".com";
        ModelAndView model = new ModelAndView();
        model.setViewName("activate");
         if (signUpService.activateAccount(account)){
             model.addObject("message", "activate successful");
         } else {
             model.addObject("message", "activate failed");
         }
         return model;
    }
}
