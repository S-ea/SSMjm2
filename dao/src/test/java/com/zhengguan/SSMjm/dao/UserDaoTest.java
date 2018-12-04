package com.zhengguan.SSMjm.dao;

import com.zhengguan.SSMjm.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@Rollback(true)
public class UserDaoTest {

    @Autowired
    UserDao userDao;
    @Test
    public void findByName() {
        System.out.println(userDao.findByName("admin"));
    }
    @Test
    public void save() {
        User user=new User();
        user.setUsername("123456");
        user.setPassword("123456");
        user.setPhone("12397563238");
        user.setEmail("23423@qq.com");
        userDao.save(user);
    }
    @Test
    public void getAll() {
        System.out.println(userDao.getAll());
    }

    @Test
    public void delete() {
        System.out.println();
    }


    @Test
    public void updates() {
        User user=new User();
            user.setId(6);
            user.setUsername("22222222");
            user.setEmail("2342@qq.com");
            user.setPhone("234234134134");
        System.out.println(userDao.updUser(user));
    }

}