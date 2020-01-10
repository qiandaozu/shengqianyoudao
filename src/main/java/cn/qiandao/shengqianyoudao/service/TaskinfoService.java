package cn.qiandao.shengqianyoudao.service;


import cn.qiandao.shengqianyoudao.pojo.Taskinfo;
import org.apache.ibatis.javassist.runtime.Desc;

import java.util.List;

public interface TaskinfoService {
    /**
     * 通过任务编号id进行查询
     * @param taskid 任务编号
     * @return
     */
    Taskinfo selectTask(String taskid);

    /**
     * 查询分类的任务集合
     * @param type
     * @return
     */
    List<Taskinfo> selectAllTask(Integer type);

    /**
     * 价格排序  desc正序  asc倒序
     * @return count
     */
    List<Taskinfo> selectByExample(String type,String sort);

    /**
     * 查询用户发布的任务
     * @param user
     * @return
     */
    List<Taskinfo> selectTasks(String user);


}
