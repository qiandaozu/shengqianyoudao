package cn.qiandao.shengqianyoudao.service;


import cn.qiandao.shengqianyoudao.pojo.Taskinfo;

public interface TaskinfoService {

    Taskinfo selectTask(int tiid);

    Taskinfo selectByTiTitle(int tiid);
}
