package com.py.api.test.dao;

import com.py.api.test.bean.User;
import com.py.api.test.bean.dto.UserDTO;

import java.util.List;


public interface UserDao {
    List<User> getAllUsers(String[] ids,String key);
    User getUser(String id);
    User updateUser(String id,UserDTO user);
    User creatUser (UserDTO user);
    void deleteUser(String id);
}
