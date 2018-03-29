package com.py.api.test.service.impl;

import com.py.api.test.bean.User;
import com.py.api.test.bean.dto.UserDTO;
import com.py.api.test.dao.UserDao;
import com.py.api.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers(String[] ids,String key) {

        return userDao.getAllUsers(ids,key);
    }

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public User updateUser(String id,UserDTO user) {
        return userDao.updateUser(id,user);
    }

    @Override
    public User creatUser(UserDTO user) {
        return userDao.creatUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }
}
