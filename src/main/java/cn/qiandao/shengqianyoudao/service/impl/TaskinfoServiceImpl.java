package cn.qiandao.shengqianyoudao.service.impl;


import cn.qiandao.shengqianyoudao.mapper.TaskinfoMapper;
import cn.qiandao.shengqianyoudao.pojo.Taskinfo;
import cn.qiandao.shengqianyoudao.service.TaskinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fyy
 * @date 2019/12/28 18:06
 **/
@Service
public class TaskinfoServiceImpl implements TaskinfoService {

    @Autowired
    private TaskinfoMapper taskinfoMapper;

    @Override
    public Taskinfo selectTask(int tiid) {
        Taskinfo taskinfo = taskinfoMapper.selectBytitasknumber(tiid);
        return taskinfo;
    }

    @Override
    public Taskinfo selectByTiTitle(int tiid) {
        return taskinfoMapper.selectBytitasknumber(tiid);
    }

}
