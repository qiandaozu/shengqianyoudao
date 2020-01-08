package cn.qiandao.shengqianyoudao.service.impl;

import cn.qiandao.shengqianyoudao.mapper.SkillRelationMapper;
import cn.qiandao.shengqianyoudao.mapper.SkillsinfoMapper;
import cn.qiandao.shengqianyoudao.pojo.Skillsinfo;
import cn.qiandao.shengqianyoudao.pojo.Skilltype;
import cn.qiandao.shengqianyoudao.pojo.Skilluserrelationship;
import cn.qiandao.shengqianyoudao.service.SkillsinfoService;
import cn.qiandao.shengqianyoudao.service.SkilltypeService;
import cn.qiandao.shengqianyoudao.service.UserService;
import cn.qiandao.shengqianyoudao.util.IDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxy
 * @date 2020/1/3 0003 23:09
 **/
@Service
public class SkillsinfoServiceImpl implements SkillsinfoService {
    private Logger log = LoggerFactory.getLogger(SkillsinfoServiceImpl.class);
    @Autowired
    private SkillsinfoMapper skillsinfoMapper;
    @Autowired
    private SkilltypeService skilltypeService;
    @Autowired
    private SkillRelationMapper skillRelationMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Skillsinfo selectBySiSerialnumber(String siSerialnumber){
        Skillsinfo s = null;
                //(Skillsinfo) redisTemplate.opsForValue().get(siSerialnumber);
        if (s == null){
            s = new Skillsinfo();
            s.setSiSerialnumber(siSerialnumber);
            s = skillsinfoMapper.selectOne(s);
            s.setSiType(getSiiType(s.getSiType()));
            String[] imgList = s.getSiImg().split(",");
            s.setSiImgages(imgList);
            s.setSiImg(imgList[0]);
            //redisTemplate.opsForValue().set(siSerialnumber,s);
        }
        return s;
    }

    @Override
    public List<Skillsinfo> selectAll() {
        List<Skillsinfo> skillsinfos = skillsinfoMapper.selectAll();
        for (Skillsinfo si : skillsinfos) {
            si.setSiImg(si.getSiImg().split(",")[0]);
            //Skillsinfo newSkills = new Skillsinfo();
            //newSkills = (Skillsinfo) redisTemplate.opsForValue().get(si.getSiSerialnumber());
            //if (newSkills == null){
                Skilluserrelationship user = getUser(si.getSiSerialnumber());
                si.setU(userService.findById(user.getSurUsernumber()));
                //redisTemplate.opsForValue().set(si.getSiSerialnumber(),newSkills);
            //}
        }
        return skillsinfos;
    }

    @Override
    public String getSiiType(String skillId){
        Skilltype skilltype1 = skilltypeService.selByStNumber(skillId);
        Skilltype skilltype2 = skilltypeService.selByStNumber(skilltype1.getStFamilynumber());
        String type = skilltype2.getStContent() + "-" + skilltype1.getStContent();
        return type;
    }

    @Override
    public int addSkills(Skillsinfo skillsinfo) {
        String skid = (String) redisTemplate.opsForValue().get("技能");
        log.info("旧值是" + skid);
        String jb = IDUtil.getNewEquipmentNo("jx", skid);
        log.info("新值是" + skid);
        redisTemplate.opsForValue().set("技能",jb);
        skillsinfo.setSiSerialnumber(jb);
        return skillsinfoMapper.insert(skillsinfo);
    }

    @Override
    public Skilluserrelationship getUser(String skillId) {
        Skilluserrelationship sur = new Skilluserrelationship();
        sur.setSurSkillnumber(skillId);
        return skillRelationMapper.selectOne(sur);
    }
}
