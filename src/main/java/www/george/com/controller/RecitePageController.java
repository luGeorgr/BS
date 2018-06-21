package www.george.com.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import www.george.com.dao.MyBookWord;
import www.george.com.dao.Word;
import www.george.com.service.MyBookService;
import www.george.com.service.ReciteService;
import www.george.com.service.UserProgressService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RecitePageController {

    @Autowired
    private ReciteService reciteService;
    @Autowired
    private UserProgressService userProgressService;
    @Autowired
    private MyBookService MyBookService;
    @RequestMapping(value = "Recite/UnKnow", method = RequestMethod.GET)
    public ModelAndView handlerUnKnow(HttpServletRequest request){

        ModelAndView model = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        String user = null;
        String bookName = null;
        String number = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                user = cookie.getValue();
            } else if(cookie.getName().equals("lexicon")){
                bookName = cookie.getValue();
            } else if(cookie.getName().equals("number")) {
                number = cookie.getValue();
            }
        }

        if(user == null || bookName == null || number== null){
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }

        Word word =  reciteService.getOneWord(user, bookName);
        model.setViewName("recite");
        model.addObject("word", word.getWord());
        model.addObject("meaning", word.getMeaning());
        model.addObject("progressPercent", reciteService.getTodayProgress(user, bookName, number));
        model.addObject("wid", word.getWid());
        return model;
    }

    @RequestMapping(value = "Recite/Know", method = RequestMethod.GET)
    public ModelAndView handlerKnow(@RequestParam("wid") String wid,
                                    HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        String user = null;
        String bookName = null;
        String number = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                user = cookie.getValue();
            } else if(cookie.getName().equals("lexicon")){
                bookName = cookie.getValue();
            } else if(cookie.getName().equals("number")) {
                number = cookie.getValue();
            }
        }
        if(user == null || bookName == null || number== null){
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }

        //跟新单词关系
        reciteService.updateDegree(user, wid, bookName, 1);
        userProgressService.updateProgressAddOne(user, bookName);


        Word word =  reciteService.getOneWord(user, bookName);
        model.setViewName("recite");
        model.addObject("word", word.getWord());
        model.addObject("meaning", word.getMeaning());
        model.addObject("progressPercent", reciteService.getTodayProgress(user, bookName, number));
        model.addObject("wid", word.getWid());
        return model;
    }

    @RequestMapping(value = "Recite/AddBook", method = RequestMethod.GET)
    public ModelAndView handlerAddBook(@Param("wid") String wid,
                                       HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        String user = null;
        String bookName = null;
        String number = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                user = cookie.getValue();
            } else if(cookie.getName().equals("lexicon")){
                bookName = cookie.getValue();
            } else if(cookie.getName().equals("number")) {
                number = cookie.getValue();
            }
        }
        if(user == null || bookName == null || number== null){
            model.setViewName("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }
        //往单词本中插入单词
        MyBookService.addWord(user, bookName, wid);

        Word word =  reciteService.getOneWord(user, bookName);
        model.setViewName("recite");
        model.addObject("word", word.getWord());
        model.addObject("meaning", word.getMeaning());
        model.addObject("progressPercent", reciteService.getTodayProgress(user, bookName, number));
        model.addObject("wid", word.getWid());
        return model;
    }
}
