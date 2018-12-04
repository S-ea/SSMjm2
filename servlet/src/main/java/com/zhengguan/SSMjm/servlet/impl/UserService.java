package com.zhengguan.SSMjm.servlet.impl;

import com.zhengguan.SSMjm.entities.NoteResult;
import com.zhengguan.SSMjm.entities.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    public NoteResult checkLogin(String name,String pwd) throws NoSuchAlgorithmException;
    public NoteResult regist(String name, String password, String phone,String email) throws NoSuchAlgorithmException;

    public List<User> queryUser();
    int deleteByIds(List<Integer>ids);

    User login(String username,String password);

    int updUser(User user);
}
