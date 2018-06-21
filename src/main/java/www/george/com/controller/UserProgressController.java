package www.george.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import www.george.com.service.UserProgressService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserProgressController {

    @Autowired
    private UserProgressService userProgressService;
    @RequestMapping(value = "Progress", method = RequestMethod.GET)
    public ModelAndView getProgress(@RequestParam("lexicon") String bookName,
                                    HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        String user = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                user = cookie.getValue();
                flag = true;
                break;
            }
        }
        if (flag){
            model.setViewName("progress");
            model.addAllObjects(userProgressService.getUserProgress(user, bookName));
            model.addObject("progressPercent", userProgressService.getProgressPercent(user, bookName));
        } else {
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
        }
        return model;
    }
}
