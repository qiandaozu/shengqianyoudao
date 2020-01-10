package cn.qiandao.shengqianyoudao.controller;


import cn.qiandao.shengqianyoudao.pojo.Taskinfo;
import cn.qiandao.shengqianyoudao.pojo.Userinfo;
import cn.qiandao.shengqianyoudao.service.TaskinfoService;
import cn.qiandao.shengqianyoudao.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 任务详情页展示
 * @author fyy
 * @date 2019/12/28 18:16
 **/
@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskinfoController {

    private static final Logger log = LoggerFactory.getLogger(TaskinfoController.class);

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TaskinfoService taskinfoService;

    @ApiImplicitParam(name = "userid", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/getTask/{taskid}")
    @ApiOperation(value = "根据任务编号id查询详情",notes = "根据任务id查询详情")
    public Taskinfo selectTask1(@PathVariable("taskid") String taskid){
        Taskinfo taskinfo = taskinfoService.selectTask(taskid);
        return taskinfo;
    }

    @GetMapping("/getTypeTask/{type}")
    @ApiOperation(value = "根据任务类型查询任务集合",notes = "根据任务类型查询任务集合")
    public List<Taskinfo> selectType(@PathVariable("type") Integer type){
        List<Taskinfo> taskinfos = taskinfoService.selectAllTask(type);
        return taskinfos;
    }

    @GetMapping("/selectUpTask/{type}/{sort}")
    @ApiOperation(value = "任务排序",notes = "任务排序")
    public List<Taskinfo> selectUp(@PathVariable("type") String type,@PathVariable("sort") String sort){
        List<Taskinfo> taskinfos = taskinfoService.selectByExample(type, sort);
        return taskinfos;
    }

    @GetMapping("/selectTasks/{user}")
    @ApiOperation(value = "获取用户发布的任务",notes = "获取用户发布的任务")
    public List<Taskinfo> selectTasks(@PathVariable("user")String user){
        
        return taskinfoService.selectTasks(user);
    }


}
