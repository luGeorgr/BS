package www.george.com.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import www.george.com.myEnum.UserState;
import www.george.com.service.SignInService;
import www.george.com.service.SignUpService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomePageController {
    @Autowired
    private SignUpService signUpService;

    @Autowired
    private SignInService signInService;
    @RequestMapping(value = "homepage.com", method = RequestMethod.GET)
    public ModelAndView showHomePage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homepage");
        mv.addObject("message", "Welcome To ReciteWebApp");
        return mv;
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ModelAndView signUp(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("emailAddress") String emailAddress,
            @RequestParam("password") String password){
        UserState state = signUpService.signUp(firstName, lastName, emailAddress, password);
        ModelAndView model = new ModelAndView("homepage");
        switch (state.getState()){
            case 0: model.addObject("message", "You need to activate you account by Email"); break;
            case 1: model.addObject("message", "You need to activate you account by Email"); break;
            case 2: model.addObject("message", "Account Exist"); break;
        }
        return model;
    }

    @RequestMapping(value = "session", method = RequestMethod.POST)
    public ModelAndView signIn(@RequestParam("emailAddress") String emailAddress,
                               @RequestParam("password") String password,
                               HttpServletResponse response,
                               HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String res = signInService.checkUser(emailAddress, password);
        if(StringUtils.isBlank(res)){
            Cookie userCookie = null;
            for(Cookie cookie : request.getCookies()){
                if(cookie.getName().equals("user")){
                    userCookie = cookie;
                    userCookie.setValue(emailAddress);
                    break;
                }
            }
            if(userCookie == null) {
                userCookie = new Cookie("user", emailAddress);
                response.addCookie(userCookie);
            }
            modelAndView.setViewName("choosepage");
        } else {
            modelAndView.addObject("message", res);
            modelAndView.setViewName("homepage");
        }
        return modelAndView;
    }

}
