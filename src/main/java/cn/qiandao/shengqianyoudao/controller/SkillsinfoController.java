package cn.qiandao.shengqianyoudao.controller;

import cn.qiandao.shengqianyoudao.pojo.Skillcomment;
import cn.qiandao.shengqianyoudao.pojo.Skillsinfo;
import cn.qiandao.shengqianyoudao.pojo.Skilluserrelationship;
import cn.qiandao.shengqianyoudao.pojo.User;
import cn.qiandao.shengqianyoudao.service.SkillcommentService;
import cn.qiandao.shengqianyoudao.service.SkillsinfoService;
import cn.qiandao.shengqianyoudao.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
        User users = userService.findById(user.getSurUsernumber());
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
    public User selectUser(@PathVariable("uid") String uid){
        return userService.findById(uid);
    }
}
