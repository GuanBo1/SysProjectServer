package cn.gzb.sys_projecth.userInfo.service;

import cn.gzb.sys_projecth.userInfo.bean.UserInfo;
import cn.gzb.sys_projecth.userInfo.dao.UserInfoInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Slf4j
public class UserInfoService {
    @Autowired
    UserInfoInterface userInfoInterface;
    public List<UserInfo> login(String userName,String password){
        return userInfoInterface.findByNameAndPassword(userName,password);
    }
}
