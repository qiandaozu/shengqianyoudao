package cn.qiandao.shengqianyoudao.controller;

import cn.qiandao.shengqianyoudao.pojo.Taskorder;
import cn.qiandao.shengqianyoudao.service.TaskorderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fyy
 * @date 2020/1/10 16:10
 **/
@Api(value = "任务订单",tags = "任务订单")
@CrossOrigin
@RestController
@RequestMapping("/taskorder")
public class TaskorderController {
    @Autowired
    private TaskorderService taskorderService;

    @GetMapping("/getOrderCount")
    @ApiOperation(value = "展示不同状态的任务数量",notes = "展示不同状态的任务数量")
    public int getOrderCount(String user, int state){
        return taskorderService.getOrderCount(user,state);
    }

    @GetMapping("/getOrderCount")
    @ApiOperation(value = "展示不同状态的任务",notes = "展示不同状态的任务")
    public List<Taskorder> getOrderState(String user, int state){
        return taskorderService.getOrderState(user,state);
    }


}
