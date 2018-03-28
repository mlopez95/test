package com.py.api.test.service;

import com.py.api.test.bean.User;
import com.py.api.test.bean.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers(String[] ids,String key);
    User getUser(String id);
    User updateUser(String id,UserDTO user);
    void deleteUser(String id);
}
