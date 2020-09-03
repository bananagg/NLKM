package com.wake.nlkm.controller;
/*

import com.wake.nlkm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@ResponseBody
// @RestController
public class UserController {
    @RequestMapping("index")
    String loginsuccess(HttpSession session, Authentication auth ) {
        Collection su=auth.getAuthorities();
        StringBuffer roleStr=new StringBuffer();
        for(Object sr : su) {
            roleStr.append(sr);
        }
        String roles=su.toString();
        String nameAndrole = "用户名:" + auth.getName() + "   角色:" + roles; // 主体名，即登录用户名
        session.setAttribute("user_session", nameAndrole);
        session.setAttribute("user_name", auth.getName());
        session.setAttribute("user_roles", roleStr);
        return "index";
    }

    @RequestMapping("/logout")
    String login(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

}
*/

import com.wake.nlkm.entity.Role;
import com.wake.nlkm.entity.User;
import com.wake.nlkm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class UserController{
    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value="/getUser",method= RequestMethod.GET)
    public User getUser(@RequestParam String username){
        User user = userService.getUserByUsername(username);
        return user;
    }

    @RequestMapping(value="/getRoles",method= RequestMethod.GET)
    public List<Role> getRoles(@RequestParam String username){
        List<Role> roleList = userService.getRoles(username);
        return roleList;
    }
}