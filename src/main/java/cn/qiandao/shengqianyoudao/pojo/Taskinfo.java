package cn.qiandao.shengqianyoudao.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Data
@ToString
public class Taskinfo implements Serializable {
    /**
     * id
     */
    private Integer tiId;

    /**
     * 任务编号
     */
    private String tiTasknumber;

    /**
     * 用户编号
     */
    private String tiUsernumber;

    /**
     * 任务标题
     */
    private String tiTitle;

    /**
     * 任务类型（填写序号）
     */
    private Integer tiType;

    /**
     * 任务金额
     */
    private Long tiMoney;

    /**
     * 截止人数
     */
    private Integer tiPeoplelimit;

    /**
     * 截止时间
     */
    private Date tiDatelimit;

    /**
     * 提交任务的时长
     */
    private Integer tiTimelimit;

    /**
     * 任务可完成次数
     */
    private Integer tiTimeslimit;

    /**
     * 任务相关链接
     */
    private String tiLink;

    /**
     * 任务描述
     */
    private String tiDescribe;

    /**
     * 任务要求
     */
    private String tiRequire;

    /**
     * 完成人数
     */
    private Integer tiCompletepeople;

    /**
     * 任务图片
     */
    private String tiMsimg;

    /**
     * 浏览量
     */
    private Integer tiPageview;

    /**
     * 任务是否可显示状态
     */
    private Integer tiState;

    /**
     * 发布时间
     */
    private Date tiDate;

    /**
     * 任务经验
     */
    private Integer tiExperience;

    /**
     * 奖励24小时内审核
     */
    private Integer tiAudit;

    /**
     * 任务要求图片
     */
    private String tiYqimg;
    /**
     * 用户
     */
    private User user;

    private static final long serialVersionUID = 1L;

}