package cn.qiandao.shengqianyoudao.service;

import cn.qiandao.shengqianyoudao.pojo.Skillsinfo;
import cn.qiandao.shengqianyoudao.pojo.Skilluserrelationship;

import java.util.List;
import java.util.Map;

/**
 * @author lxy
 * @date 2020/1/4 0004 18:46
 **/
public interface SkillsinfoService {
    Skillsinfo selectBySiSerialnumber(String siSerialnumber);
    List<Skillsinfo> selectAll();
    String getSiiType(String skillId);
    int addSkills(Skillsinfo skillsinfo);
    Skilluserrelationship getUser(String skillId);

    //获取db所有技能编号
    String getMaxskill();
    //插入数据库
    String pubSkill(Map InsertSkillinfo);

    String makeSkillID();
}
