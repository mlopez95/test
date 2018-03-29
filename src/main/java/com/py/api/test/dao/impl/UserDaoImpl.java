package com.py.api.test.dao.impl;

import com.py.api.test.bean.User;
import com.py.api.test.bean.dto.UserDTO;
import com.py.api.test.dao.UserDao;
import com.py.api.test.utils.APIResolver;
import com.py.api.test.utils.Constans;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public List<User> getAllUsers(String[] ids,String key) {
        return APIResolver.doGet(Constans.URL_REST_FAKE,"/users",new ParameterizedTypeReference<List<User>>(){},ids,key);
    }

    @Override
    public User getUser(String id) {
        return APIResolver.doGet(Constans.URL_REST_FAKE,"/users/"+id,User.class,null);
    }

    @Override
    public User updateUser(String id,UserDTO user) {
        return APIResolver.doPut(Constans.URL_REST_FAKE,"/users/"+id,user,User.class);
    }

    @Override
    public User creatUser(UserDTO user) {
        return APIResolver.doPost(Constans.URL_REST_FAKE,"/users/",user,User.class);
    }

    @Override
    public void deleteUser(String id) {
        APIResolver.doDelete(Constans.URL_REST_FAKE,"/users/"+id,Void.class);
    }
}
