package cn.qiandao.shengqianyoudao.controller;


import cn.qiandao.shengqianyoudao.pojo.Taskinfo;
import cn.qiandao.shengqianyoudao.service.TaskinfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping("/getTask01/{tiid}")
    @ApiOperation(value = "根据商品id查询详情",notes = "根据商品id查询详情")
    public Taskinfo selectTask(@PathVariable("tiid") int tiid){
        Taskinfo redtaskinfo = (Taskinfo) redisTemplate.opsForValue().get("taskinfo");
        //redis中没有数据 从mysql数据库获取
        if (redtaskinfo == null){
            Taskinfo taskinfo = taskinfoService.selectTask(tiid);
            redisTemplate.opsForValue().set("taskinfo",taskinfo);
            log.info(String.valueOf(taskinfo));
            return taskinfo;
        }
        return redtaskinfo;
    }

    @ApiImplicitParam(name = "userid", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/getTask/{tiid}")
    @ApiOperation(value = "根据商品id查询详情",notes = "根据商品id查询详情")
    public Taskinfo getTask(@PathVariable("tiid") int tiid){
        Taskinfo redtaskinfo = (Taskinfo) redisTemplate.opsForValue().get("taskinfo");
        //redis中没有数据 从mysql数据库获取
        if (redtaskinfo == null){
            Taskinfo taskinfo = taskinfoService.selectByTiTitle(tiid);
            redisTemplate.opsForValue().set("taskinfo",taskinfo);
            log.info(String.valueOf(taskinfo));
            return taskinfo;
        }
        return redtaskinfo;
    }
}
