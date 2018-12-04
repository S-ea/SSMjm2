package com.zhengguan.SSMjm.servlet.impl.Impl;


import com.zhengguan.SSMjm.commutil.NoteUtil;
import com.zhengguan.SSMjm.dao.UserDao;
import com.zhengguan.SSMjm.entities.NoteResult;
import com.zhengguan.SSMjm.entities.User;
import com.zhengguan.SSMjm.servlet.impl.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao; //注入
    public NoteResult checkLogin(String name, String pwd) throws NoSuchAlgorithmException {
        NoteResult result = new NoteResult();
        User user = userDao.findByName(name);
        if(user==null){
            result.setStatus(1);
            result.setMsg("用户名不存在");
            return result;
        }
        //将用户输入的pwd密码加密
        String md5_pwd= NoteUtil.md5(pwd);
        //与数据库密码比对
        if(!user.getPassword().equals(md5_pwd)){
            result.setStatus(2);
            result.setMsg("密码不正确");
            return  result;
        }
        result.setStatus(0);
        result.setMsg("用户名和密码正确");
        result.setData(user.getId());//返回userID
        return  result;
    }

    public NoteResult regist(String name, String password, String phone,String email) throws NoSuchAlgorithmException {
        NoteResult result = new NoteResult();
        //检测用户名是否被占用
        User hash_user=userDao.findByName(name);
        if(hash_user!=null){
            result.setStatus(1);
            result.setMsg("用户名已被占用");
            return  result;
        }
        User user = new User();
        user.setUsername(name);
        String md5_pwd = NoteUtil.md5(password);
        user.setPassword(md5_pwd);
        user.setPhone(phone);
        user.setEmail(email);
        //调用userDao保存
        userDao.save(user);
        result.setStatus(0);
        result.setMsg("注册成功");
        return result;
    }

    public List<User> queryUser() {
        return userDao.getAll();
    }



    public int deleteByIds(List<Integer> ids) {
        if (ids==null||ids.size()<=0){
            return 0;
        }
        return userDao.deletes(ids);
    }


    public User login(String username, String password) {

        return userDao.findWithLoginAndPassword(username, password);
    }

    public int updUser(User user) {
        return userDao.updUser(user);
    }

}
