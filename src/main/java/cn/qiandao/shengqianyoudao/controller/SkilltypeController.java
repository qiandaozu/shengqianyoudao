package cn.qiandao.shengqianyoudao.controller;

import cn.qiandao.shengqianyoudao.pojo.Skilltype;
import cn.qiandao.shengqianyoudao.service.SkilltypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lxy
 * @date 2020/1/5 0005 16:24
 **/
@RestController
@CrossOrigin
@RequestMapping("/skilltype")
@Api(value="/skilltype",description="技能类型API")
public class SkilltypeController {
    @Autowired
    private SkilltypeService skilltypeService;

    @GetMapping("/sel")
    @ApiImplicitParam(name = "stid", value = "技能类型编号", required = true, dataType = "string", paramType = "path")
    public List<Skilltype> getByFamilyAll(@RequestParam(value = "stid", defaultValue = "jn0098") String siFamilyId){
        return skilltypeService.getByFamilyAll(siFamilyId);
    }
}
