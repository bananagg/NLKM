package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.Role;
import com.wake.nlkm.entity.User;
import com.wake.nlkm.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author Ganty
 * @Date 2020/8/18
 * @Des
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper sysUserMapper;

    public User getUserByUsername(String username)  {
        User user= sysUserMapper.findUserByName(username);
        return user;
    }

    public List<Role> getRoles(String userId){
        List<Role> roleList = sysUserMapper.findRoleById(userId);
        return roleList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= sysUserMapper.findUserByName(username);
        if(user == null){
            System.out.println("用户名不存在");
            throw new UsernameNotFoundException("用户名不存在");
        }else {
            System.out.println("username:"+user.getUsername());
            System.out.println("password:"+user.getPassword());
        }
        return user;
    }
}
