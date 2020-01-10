package cn.qiandao.shengqianyoudao.service;

import cn.qiandao.shengqianyoudao.pojo.Skilluserrelationship;

public interface ISkillRelationService{
    //插入用户信息
    int addUserSkill(String userId,String skillId);
}
