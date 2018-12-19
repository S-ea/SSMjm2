package com.zhengguan.SSMjm.dao;

import com.zhengguan.SSMjm.entities.Goods;
import com.zhengguan.SSMjm.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public User findByName(String name);

    public void save(User user);

    public List<User> getAll();

    int deletes(@Param("ids") List<Integer>ids);

    User findWithLoginAndPassword(@Param("username")String username,@Param("password")String password);

    int updpwd(@Param("id") int id,@Param("passWord") String passWord);

    int updUser(User user);


    public  List<Goods>selectgoods();

    int deletegood(int id);

    int insertgood(Goods goods);

    int updategood(Goods goods);



}
