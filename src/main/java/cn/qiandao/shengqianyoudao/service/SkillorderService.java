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
    int addKillOrder(Skillorder skillorder);

    /**
     * 修改订单 订单的状态
     * @param orderId 订单号
     * @param state 状态
     * @return
     */
    int updateOrder(String orderId,int state);

    /**
     * 查询订单
     * @param orderid
     * @return
     */
    Skillorder selectOrder(String orderid);

    /**
     * 用户技能查询
     * @param user 用户编号
     * @return
     */
    List<Skillorder> selectUserOrder(String user);

     List<Skillorder> selectByOrder(String Byuser);
}
