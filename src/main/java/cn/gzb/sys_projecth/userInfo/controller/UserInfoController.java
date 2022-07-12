package cn.gzb.sys_projecth.userInfo.controller;

import cn.gzb.sys_projecth.userInfo.bean.UserInfo;
import cn.gzb.sys_projecth.userInfo.service.UserInfoService;
import cn.gzb.sys_projecth.utils.ErrorCodeMsg;
import cn.gzb.sys_projecth.utils.ResultObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userInfo")
@Slf4j
@Api(value = "用户信息")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/login")
    @ApiOperation(value = "用户登录",notes = "用户登录验证")
    public ResultObject login(
            @ApiParam(value = "登陆信息",required = true,example = "{userName:XXX,password:xxx}")
            @RequestBody
            Map<String, String> params
    ){
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
