package cn.qiandao.shengqianyoudao.controller;

import cn.qiandao.shengqianyoudao.pojo.Skillcomment;
import cn.qiandao.shengqianyoudao.pojo.Skillsinfo;
import cn.qiandao.shengqianyoudao.pojo.Skilluserrelationship;
import cn.qiandao.shengqianyoudao.pojo.Userinfo;
import cn.qiandao.shengqianyoudao.service.SkillcommentService;
import cn.qiandao.shengqianyoudao.service.SkillsinfoService;
import cn.qiandao.shengqianyoudao.service.UserService;
import cn.qiandao.shengqianyoudao.util.IDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxy
 * @date 2020/1/3 0003 23:13
 **/
@Controller
@CrossOrigin
@RequestMapping("/skills")
@Api(value="/cashrecord",description="技能信息API")
public class SkillsinfoController {
    @Autowired(required=true)
    private SkillsinfoService skillsinfoService;
    @Autowired
    private SkillcommentService skillcommentService;
    @Autowired
    private UserService userService;

    @GetMapping("/selAll")
    @ResponseBody
    @ApiOperation(value = "查询技能信息", notes = "查询技能信息")
    public List<Skillsinfo> selectAll(){
        return skillsinfoService.selectAll();
    }

    @GetMapping("/sel/{skillId}")
    @ResponseBody
    @ApiOperation(value = "技能详情页信息", notes = "技能详情页信息")
    public Map<String,Object> getSkillOrder(@PathVariable("skillId") String skillId){
        Map<String,Object> map = new HashMap<String, Object>();
        Skillsinfo skillsinfo = skillsinfoService.selectBySiSerialnumber(skillId);
        List<Skillcomment> skillcomments = skillcommentService.selSkillcomment(skillId);
        Skilluserrelationship user = skillsinfoService.getUser(skillId);
        Userinfo users = userService.findById(user.getSurUsernumber());
        map.put("skillsinfo",skillsinfo);
        map.put("skillcomments",skillcomments);
        map.put("users",users);
        return map;
    }

    @GetMapping("/seluid/{skillId}")
    @ResponseBody
    public Skilluserrelationship selectAll(@PathVariable("skillId") String skillId){
        return skillsinfoService.getUser(skillId);
    }

    @GetMapping("/seluser/{uid}")
    @ResponseBody
    public Userinfo selectUser(@PathVariable("uid") String uid){
        return userService.findById(uid);
    }

    //发布技能zrf
    @RequestMapping("/insertSkill")
    public String insertSkill(@RequestBody Map userMap){
        System.out.println(1);
        System.out.println(userMap);
        /*userMap.put("userId",userId);
        userMap.put("siTitle",siTitle);
        userMap.put("siType",siType);
        userMap.put("siMoney",siMoney);
        userMap.put("siDescribe",siDescribe);
        userMap.put("siDuration",siDuration);
        userMap.put("siDate",siDate);
        userMap.put("siImg",siImg);
        userMap.put("siModifynumber",siModifynumber);*/
        String putResult = skillsinfoService.pubSkill(userMap);
        System.out.println(putResult);
        return putResult;
    }

    @Autowired
    static RedisTemplate redisTemplate;
    public static void main(String[] args) {
        String skid = (String) redisTemplate.opsForValue().get("技能");
        String addskill = IDUtil.getNewEquipmentNo("jx",skid);
        System.out.println(addskill);
    }
}
