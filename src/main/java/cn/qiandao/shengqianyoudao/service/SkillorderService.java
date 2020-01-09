package cn.qiandao.shengqianyoudao.service;

import cn.qiandao.shengqianyoudao.pojo.Skillorder;

import java.util.List;

/**
 * @author fyy
 * @date 2020/1/7 20:34
 **/
public interface SkillorderService {
    /**
     * 添加技能订单
     * @param skillorder 技能订单实体类
     * @return
     */
    Skillorder addKillOrder(Skillorder skillorder);

    /**
     * 修改订单状态
     * 分页查询订单
     *
     */

    /**
     * 用户技能查询
     * @param user 用户编号
     * @return
     */
    List<Skillorder> selectUserOrder(String user);

    /**
     * 购买的技能查询
     * @param Byuser
     * @return
     */
    List<Skillorder> selectByOrder(String Byuser);
}
