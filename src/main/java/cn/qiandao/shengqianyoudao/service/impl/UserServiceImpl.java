package cn.qiandao.shengqianyoudao.service.impl;

import cn.qiandao.shengqianyoudao.mapper.UserMapper;
import cn.qiandao.shengqianyoudao.pojo.User;
import cn.qiandao.shengqianyoudao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fyy
 * @date 2019/12/25 16:03
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User findById(String id) {
        User u = new User();
        u.setNumber(id);
        return userMapper.selectOne(u);
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

}
