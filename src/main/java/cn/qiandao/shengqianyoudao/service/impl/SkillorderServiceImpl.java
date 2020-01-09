package cn.qiandao.shengqianyoudao.service.impl;


import cn.qiandao.shengqianyoudao.mapper.SkillorderMapper;
import cn.qiandao.shengqianyoudao.pojo.Skillorder;
import cn.qiandao.shengqianyoudao.pojo.Skillsinfo;
import cn.qiandao.shengqianyoudao.service.SkillorderService;
import cn.qiandao.shengqianyoudao.service.SkillsinfoService;
import cn.qiandao.shengqianyoudao.util.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author fyy
 * @date 2020/1/8 10:02
 **/
@Slf4j
@Service
public class SkillorderServiceImpl implements SkillorderService {

    @Autowired
    private SkillorderMapper skillorderMapper;
    @Autowired
    private SkillsinfoService skillsinfoService;

    //雪花算法
    private SnowFlake snowFlake = new SnowFlake(2,3);


    @Override
    public Skillorder addKillOrder(Skillorder skillorder) {
        //当前时间（为了简化模板）
        Date orderTime = new Date();
        //雪花算法生成随机数
        String orderNo = String.valueOf(snowFlake.nextId());

        //订单编号
        skillorder.setSoNumber(orderNo);
        //购买的时间
        skillorder.setSoPurchasingdate(orderTime);
        //最后更改的时间
        skillorder.setSoEnddate(orderTime);

        int insert = skillorderMapper.insert(skillorder);
        System.out.println(insert);
        Skillorder skillorder1 = skillorderMapper.selectOne(skillorder);
        return skillorder1;
    }

    @Override
    public List<Skillorder> selectUserOrder(String user) {
        Skillorder skillorder = new Skillorder();
        skillorder.setSoSkilluser(user);
        List<Skillorder> orders = skillorderMapper.select(skillorder);
        return orders;
    }

    @Override
    public List<Skillorder> selectByOrder(String Byuser) {
        Skillorder skillorder = new Skillorder();
        skillorder.setSoBuyusernumber(Byuser);
        List<Skillorder> orders = skillorderMapper.select(skillorder);
        return orders;
    }

}
