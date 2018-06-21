package www.george.com.controller;

import org.apache.ibatis.annotations.Param;
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
    public ModelAndView handleRequest(@Param("method") String method,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        if(method.equals("show")){
            return getModelAndView(request,response);
        }

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
            Integer degree = (method.compareTo("forget") == 0) ? 0 : 2;
            //update degree
            reviewService.updateWordDegree(user, bid, wid, degree);
        }
        return  getModelAndView(request, response);
    }

    private ModelAndView getModelAndView(HttpServletRequest request, HttpServletResponse response){
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
            model.addObject("word", "You have finish all");
            model.addObject("meaning", "You can choose go back to lean or exam it");
            if(bid != null) {
                bid.setMaxAge(0);
            }
            bid = new Cookie("bid", "-1");
            response.addCookie(bid);
            if(wid == null){
                wid.setMaxAge(0);
            }
            wid = new Cookie("wid", "-1");
            response.addCookie(wid);
        } else {
            model.addObject("word", word.getWord());
            model.addObject("meaning", word.getMeaning());
            if(bid != null) {
                bid.setMaxAge(0);
            }
            bid = new Cookie("bid", word.getBid());
            response.addCookie(bid);
            if(wid == null){
                wid.setMaxAge(0);
            }
            wid = new Cookie("wid", word.getWid().toString());
            response.addCookie(wid);
        }
        return model;
    }
}
