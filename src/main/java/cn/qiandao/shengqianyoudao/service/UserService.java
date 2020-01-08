package cn.qiandao.shengqianyoudao.service;

import cn.qiandao.shengqianyoudao.pojo.User;

import java.util.List;

public interface UserService {
    public int save(User user);
    public User findById(String id);
    public int delete(User user);
    public List<User> findAll();
}
