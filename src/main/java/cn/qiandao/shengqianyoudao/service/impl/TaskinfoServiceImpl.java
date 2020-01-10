package cn.qiandao.shengqianyoudao.service.impl;


import cn.qiandao.shengqianyoudao.mapper.TaskinfoMapper;
import cn.qiandao.shengqianyoudao.pojo.Taskinfo;
import cn.qiandao.shengqianyoudao.pojo.User;
import cn.qiandao.shengqianyoudao.pojo.Userinfo;
import cn.qiandao.shengqianyoudao.service.TaskinfoService;
import cn.qiandao.shengqianyoudao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author fyy
 * @date 2019/12/28 18:06
 **/
@Service
public class TaskinfoServiceImpl implements TaskinfoService {

    private final Logger log = LoggerFactory.getLogger(TaskinfoServiceImpl.class);
    @Autowired
    private TaskinfoMapper taskinfoMapper;

    @Autowired
    private UserService userService;

    @Override
    public Taskinfo selectTask(String taskid) {
        //1.将传进来的参数加入实体类
        Taskinfo taskinfo = new Taskinfo();
        taskinfo.setTiTasknumber(taskid);

        //2.用selectOne放入实体类  利用实体类中的参数进行查询  返回实体类
        Taskinfo task = taskinfoMapper.selectOne(taskinfo);

        //3.因user和任务锁绑定  利用任务查询出来的用户id 当参数用userservice的方法进行查询用户
        Userinfo user = userService.findById(task.getTiUsernumber());

        //4.将user放入task实体类中封装
        task.setUser(user);

        //6.返回对象
        return task;
    }

    //查询分类的任务集合
    @Override
    public List<Taskinfo> selectAllTask(Integer type) {
        Taskinfo taskinfo = new Taskinfo();
        taskinfo.setTiType(type);
        Userinfo user = userService.findById(taskinfo.getTiUsernumber());
        taskinfo.setUser(user);
        List<Taskinfo> tasks = taskinfoMapper.select(taskinfo);
        return tasks;
    }

    //任务价格排序  desc正序  asc倒序
    @Override
    public List<Taskinfo> selectByExample(String type,String sort) {
        Example example = new Example(Taskinfo.class);
        if(sort.equals("asc")){
            example.orderBy(type).asc();
        }
        example.orderBy(type).desc();
        return taskinfoMapper.selectByExample(example);
    }

    //查询用户发布的任务
    @Override
    public List<Taskinfo> selectTasks(String user) {
        Taskinfo taskinfo = new Taskinfo();
        taskinfo.setTiUsernumber(user);
        Userinfo u = userService.findById(taskinfo.getTiUsernumber());
        taskinfo.setUser(u);
        return taskinfoMapper.select(taskinfo);
    }




}
