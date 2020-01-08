package cn.qiandao.shengqianyoudao.service;

import cn.qiandao.shengqianyoudao.pojo.Skillsinfo;
import cn.qiandao.shengqianyoudao.pojo.Skilluserrelationship;

import java.util.List;
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
}
