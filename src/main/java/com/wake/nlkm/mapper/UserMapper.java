package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Role;
import com.wake.nlkm.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author Ganty
 * @Date 2020/8/18
 * @Des
 */

@Mapper
public interface UserMapper {

    User findUserByName(@Param("username")String username);
    List<Role> findRoleById(@Param("userId")String userId);

}
