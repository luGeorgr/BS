package www.george.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import www.george.com.dao.Word;
import www.george.com.service.ReviewService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @RequestMapping(value = "Review", method = RequestMethod.GET)
    public ModelAndView getReviewWord(HttpServletRequest request, HttpServletResponse response){
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

        model.setViewName("review");
        Word word =  reviewService.getOneWord(user);

        Cookie bid = null;
        Cookie wid = null;
        for(Cookie cookie : request.getCookies()){
            if(cookie.getName().equals("bid")){
                bid = cookie;
            } else if(cookie.getName().equals("wid")){
                wid = cookie;
            }
        }

        if(word == null){
            model.addObject("word", "");
            model.addObject("meaning", "");
            if(bid == null) {
                bid = new Cookie("bid", "-1");
                response.addCookie(bid);
            }
            bid.setValue("-1");
            if(wid == null){
                wid = new Cookie("wid", "-1");
                response.addCookie(wid);
            }
            wid.setValue("-1");
        } else {
            model.addObject("word", word.getWord());
            model.addObject("meaning", word.getMeaning());
            if(bid == null) {
                bid = new Cookie("bid", word.getBid());
                response.addCookie(bid);
            }
            bid.setValue(word.getBid());
            if(wid == null){
                wid = new Cookie("wid", word.getWid().toString());
                response.addCookie(wid);
            }
            wid.setValue(word.getWid().toString());
        }
        return model;
    }

    @RequestMapping(value = "Review/Forget", method = RequestMethod.GET)
    public ModelAndView forget(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String user = null;
        Integer bid = null;
        Integer wid = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                user = cookie.getValue();
            } else if(cookie.getName().equals("bid")){
                bid = Integer.parseInt(cookie.getValue());
            } else if(cookie.getName().equals("wid")){
                wid = Integer.parseInt(cookie.getValue());
            }
        }

        if(user == null || bid == null || wid == null){
            ModelAndView model = new ModelAndView("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }

        if(bid >= 0) {
            //update degree
            reviewService.updateWordDegree(user, bid, wid, 0);
        }
        return  getReviewWord(request, response);
    }

    @RequestMapping(value = "Review/Well", method = RequestMethod.GET)
    public ModelAndView wellKnow(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String user = null;
        Integer bid = null;
        Integer wid = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                user = cookie.getValue();
            } else if(cookie.getName().equals("bid")){
                bid = Integer.parseInt(cookie.getValue());
            } else if(cookie.getName().equals("wid")){
                wid = Integer.parseInt(cookie.getValue());
            }
        }

        if(user == null || bid == null || wid == null){
            ModelAndView model = new ModelAndView("homepage");
            model.addObject("message", "User authentication expired ");
            return model;
        }
        if(bid >= 0) {
            //update degree
            reviewService.updateWordDegree(user, bid, wid, 2);
        }
        return getReviewWord(request, response);
    }
}
