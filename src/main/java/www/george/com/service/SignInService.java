package www.george.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.george.com.dao.UserInfo;
import www.george.com.mapper.UserInfoMapper;

@Service
public class SignInService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public String checkUser(final String emailAddr, final String password) {
        UserInfo userInfo = userInfoMapper.existAccount(emailAddr);
        if(userInfo == null){
            return "user not exists";
        }

        if(userInfo.getEmailState() == 0){
            return "user do not activate yet";
        }

        if(!userInfo.getPassword().equals(password)){
            return "password error";
        }
        return "";
    }
}
