package www.george.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import www.george.com.service.ExamService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ExamController {

    @Autowired
    private ExamService examService;
    @RequestMapping(value = "Exam", method = RequestMethod.GET)
    public ModelAndView getExamWord(HttpServletRequest request){
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
            model.setViewName("exam");
            model.addAllObjects(examService.getModelMap(user));
        } else {
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
        }
        return model;
    }

    @RequestMapping(value = "Exam/Result", method = RequestMethod.GET)
    public ModelAndView examResultResponse(@RequestParam("wid") String wid,
                                           @RequestParam("bid") String bid,
                                           @RequestParam("state") String state,
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
            if(state.equals("0")){
                examService.updateDegree(user, Integer.parseInt(bid), Integer.parseInt(wid), 1);
            }else{
                examService.updateDegree(user, Integer.parseInt(bid), Integer.parseInt(wid), 3);
            }
            model.setViewName("exam");
            model.addAllObjects(examService.getModelMap(user));
        } else {
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
        }
        return model;
    }
}
