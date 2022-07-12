package cn.gzb.sys_projecth.userInfo.controller;

import cn.gzb.sys_projecth.userInfo.bean.UserInfo;
import cn.gzb.sys_projecth.userInfo.service.UserInfoService;
import cn.gzb.sys_projecth.utils.ErrorCodeMsg;
import cn.gzb.sys_projecth.utils.ResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userInfo")
@Slf4j
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/login")
    public ResultObject login(@RequestBody Map<String, String> params){
        try{
            String userName = params.get("userName");
            String password = params.get("password");
            List<UserInfo> list =  userInfoService.login(userName, password);
            if(list.size() > 0){
                return new ResultObject(ErrorCodeMsg.SUCCESS_CODE,"用户名或者密码错误");
            }
            return new ResultObject(ErrorCodeMsg.ERROR_CODE,ErrorCodeMsg.ERROR_MESSAGE);
        }catch (Exception e) {
            return new ResultObject(ErrorCodeMsg.ERROR_INPUT_PARAMS_CODE,ErrorCodeMsg.ERROR_INPUT_PARAMS_MESSAGE);
        }
    }
}
