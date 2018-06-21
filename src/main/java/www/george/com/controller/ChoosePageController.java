package www.george.com.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import www.george.com.dao.Word;
import www.george.com.service.ReciteService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ChoosePageController {
    @Autowired
    private ReciteService reciteService;
    @RequestMapping(value = "ChoosePage", method = RequestMethod.GET)
    public String getChoosePage(){
        return "choosepage";
    }

    @RequestMapping(value = "Recite", method = RequestMethod.GET)
    public ModelAndView getRecitePage(@RequestParam("lexicon") String bookName,
                                      @RequestParam("number") String number,
                                      HttpServletResponse response,
                                      HttpServletRequest request){
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
        if(!flag){
            ModelAndView model = new ModelAndView("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }
        reciteService.addBook(user, bookName);

        Cookie cookielexicon = new Cookie("lexicon", bookName);
        Cookie cookieNumber = new Cookie("number", number);
        response.addCookie(cookielexicon);
        response.addCookie(cookieNumber);
        ModelAndView model = new ModelAndView("recite");
        Word word =  reciteService.getOneWord(user, bookName);
        model.addObject("word", word.getWord());
        model.addObject("meaning", word.getMeaning());
        model.addObject("progressPercent", reciteService.getTodayProgress(user, bookName, number));
        model.addObject("wid", word.getWid());
        return model;
    }
}
