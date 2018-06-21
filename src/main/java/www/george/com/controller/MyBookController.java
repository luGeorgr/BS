package www.george.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import www.george.com.dao.Word;
import www.george.com.service.MyBookService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyBookController {
    @Autowired
    private MyBookService myBookService;
    @RequestMapping(value = "MyBook", method = RequestMethod.GET)
    public ModelAndView showWordByIndex(@RequestParam("index") String strIndex,
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
        if (!flag){
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }

        model.setViewName("mybook");
        Word word = myBookService.getWord(user,Integer.parseInt(strIndex));
        model.addObject("word", word.getWord());
        model.addObject("meaning", word.getMeaning());
        model.addObject("index", word.getIndex());
        model.addObject("progressPercent", myBookService.getProgressPercent(user, Integer.parseInt(strIndex)));
        return model;
    }

    @RequestMapping(value = "MyBook/Last", method = RequestMethod.GET)
    public ModelAndView showLastWord(@RequestParam("index") String strIndex,
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
        if (!flag){
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }

        model.setViewName("mybook");
        Word word = myBookService.getLastWord(user,Integer.parseInt(strIndex));
        model.addObject("word", word.getWord());
        model.addObject("meaning", word.getMeaning());
        model.addObject("index", word.getIndex());
        model.addObject("progressPercent", myBookService.getProgressPercent(user, Integer.parseInt(strIndex) -  1));
        return model;
    }


    @RequestMapping(value = "MyBook/Next", method = RequestMethod.GET)
    public ModelAndView showNextWord(@RequestParam("index") String strIndex,
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
        if (!flag){
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }

        model.setViewName("mybook");
        Word word = myBookService.getNextWord(user,Integer.parseInt(strIndex));
        model.addObject("word", word.getWord());
        model.addObject("meaning", word.getMeaning());
        model.addObject("index", word.getIndex());
        model.addObject("progressPercent", myBookService.getProgressPercent(user, Integer.parseInt(strIndex) + 1));
        return model;
    }
}
