package cn.qiandao.shengqianyoudao.service.impl;

import cn.qiandao.shengqianyoudao.mapper.SkillRelationMapper;
import cn.qiandao.shengqianyoudao.mapper.SkillsinfoMapper;
import cn.qiandao.shengqianyoudao.pojo.Skillsinfo;
import cn.qiandao.shengqianyoudao.pojo.Skilltype;
import cn.qiandao.shengqianyoudao.pojo.Skilluserrelationship;
import cn.qiandao.shengqianyoudao.service.SkillsinfoService;
import cn.qiandao.shengqianyoudao.service.SkilltypeService;
import cn.qiandao.shengqianyoudao.service.UserService;
import cn.qiandao.shengqianyoudao.util.CheckSensitiveWords;
import cn.qiandao.shengqianyoudao.util.IDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private CheckSensitiveWords checkSensitiveWords;
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


    @Override
    public String getMaxskill() {
        String maxSkill = skillsinfoMapper.getMaxSkillId();
        redisTemplate.opsForValue().set("maxSkill",maxSkill);
        System.out.println("最大技能id"+maxSkill);
        return maxSkill;
    }

    @Override
    public String makeSkillID() {
        String maxskilString = "";
        maxskilString = redisTemplate.opsForValue().get("maxSkill").toString();
        System.out.println("redis中技能id最大值："+maxskilString);
        if (maxskilString.equals("")){
            maxskilString = getMaxskill();
        }
        System.out.println(maxskilString+"-------");
        int numberSkillid = (Integer.parseInt(maxskilString.substring(2)))+1;
        System.out.println(maxskilString.substring(2));
        maxskilString = "jx"+String.format("%06d",numberSkillid);
        System.out.println("加1后的技能id："+maxskilString);
        return maxskilString;
    }


    @Override
    public String pubSkill(Map InsertSkillinfo) {
        boolean checkTitle = checkSensitiveWords.checkWorks(InsertSkillinfo.get("siTitle").toString());
        boolean checkDescribe = checkSensitiveWords.checkWorks(InsertSkillinfo.get("siDescribe").toString());
        if (checkTitle == true && checkDescribe == true){
            BigDecimal bigDecimal = new BigDecimal(InsertSkillinfo.get("siMoney").toString());
            Skillsinfo skillsinfo = new Skillsinfo();
            skillsinfo.setSiId(0);
            skillsinfo.setSiSerialnumber(makeSkillID());
            skillsinfo.setSiTitle(InsertSkillinfo.get("siTitle").toString());
            skillsinfo.setSiType(skilltypeService.getSkillId(InsertSkillinfo.get("siType").toString()));
            skillsinfo.setSiMoney(bigDecimal);
            skillsinfo.setSiDescribe(InsertSkillinfo.get("siDescribe").toString());
            skillsinfo.setSiDuration(Integer.parseInt(InsertSkillinfo.get("siDuration").toString()));
            skillsinfo.setSiDate(InsertSkillinfo.get("siDate").toString());
            skillsinfo.setSiImg(InsertSkillinfo.get("siImg").toString());
            skillsinfo.setSiAuthority(0);
            skillsinfo.setSiModifynumber(Integer.parseInt(InsertSkillinfo.get("siModifynumber").toString()));
            skillsinfo.setSiState(0);
            skillsinfo.setSiTostate(2);
            skillsinfo.setSiGrade(0);
            int insertResult = skillsinfoMapper.insert(skillsinfo);
            System.out.println("向数据库插入技能："+insertResult);
            System.out.println("技能信息"+skillsinfo);
            redisTemplate.opsForValue().set("maxSkill",skillsinfo.getSiSerialnumber());
            System.out.println("skillid存入redis"+redisTemplate.opsForValue().get("maxSkill"));
            return "技能填写完成 进入审核状态";
        }else {
            return "技能填写失败";
        }
    }




}
