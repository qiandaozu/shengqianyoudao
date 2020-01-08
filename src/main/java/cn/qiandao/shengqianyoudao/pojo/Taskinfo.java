package cn.qiandao.shengqianyoudao.pojo;

import java.io.Serializable;
import java.util.Date;

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
    private Userinfo userinfo;

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    private static final long serialVersionUID = 1L;

    public Integer getTiId() {
        return tiId;
    }

    public void setTiId(Integer tiId) {
        this.tiId = tiId;
    }

    public String getTiTasknumber() {
        return tiTasknumber;
    }

    public void setTiTasknumber(String tiTasknumber) {
        this.tiTasknumber = tiTasknumber;
    }

    public String getTiUsernumber() {
        return tiUsernumber;
    }

    public void setTiUsernumber(String tiUsernumber) {
        this.tiUsernumber = tiUsernumber;
    }

    public String getTiTitle() {
        return tiTitle;
    }

    public void setTiTitle(String tiTitle) {
        this.tiTitle = tiTitle;
    }

    public Integer getTiType() {
        return tiType;
    }

    public void setTiType(Integer tiType) {
        this.tiType = tiType;
    }

    public Long getTiMoney() {
        return tiMoney;
    }

    public void setTiMoney(Long tiMoney) {
        this.tiMoney = tiMoney;
    }

    public Integer getTiPeoplelimit() {
        return tiPeoplelimit;
    }

    public void setTiPeoplelimit(Integer tiPeoplelimit) {
        this.tiPeoplelimit = tiPeoplelimit;
    }

    public Date getTiDatelimit() {
        return tiDatelimit;
    }

    public void setTiDatelimit(Date tiDatelimit) {
        this.tiDatelimit = tiDatelimit;
    }

    public Integer getTiTimelimit() {
        return tiTimelimit;
    }

    public void setTiTimelimit(Integer tiTimelimit) {
        this.tiTimelimit = tiTimelimit;
    }

    public Integer getTiTimeslimit() {
        return tiTimeslimit;
    }

    public void setTiTimeslimit(Integer tiTimeslimit) {
        this.tiTimeslimit = tiTimeslimit;
    }

    public String getTiLink() {
        return tiLink;
    }

    public void setTiLink(String tiLink) {
        this.tiLink = tiLink;
    }

    public String getTiDescribe() {
        return tiDescribe;
    }

    public void setTiDescribe(String tiDescribe) {
        this.tiDescribe = tiDescribe;
    }

    public String getTiRequire() {
        return tiRequire;
    }

    public void setTiRequire(String tiRequire) {
        this.tiRequire = tiRequire;
    }

    public Integer getTiCompletepeople() {
        return tiCompletepeople;
    }

    public void setTiCompletepeople(Integer tiCompletepeople) {
        this.tiCompletepeople = tiCompletepeople;
    }

    public String getTiMsimg() {
        return tiMsimg;
    }

    public void setTiMsimg(String tiMsimg) {
        this.tiMsimg = tiMsimg;
    }

    public Integer getTiPageview() {
        return tiPageview;
    }

    public void setTiPageview(Integer tiPageview) {
        this.tiPageview = tiPageview;
    }

    public Integer getTiState() {
        return tiState;
    }

    public void setTiState(Integer tiState) {
        this.tiState = tiState;
    }

    public Date getTiDate() {
        return tiDate;
    }

    public void setTiDate(Date tiDate) {
        this.tiDate = tiDate;
    }

    public Integer getTiExperience() {
        return tiExperience;
    }

    public void setTiExperience(Integer tiExperience) {
        this.tiExperience = tiExperience;
    }

    public Integer getTiAudit() {
        return tiAudit;
    }

    public void setTiAudit(Integer tiAudit) {
        this.tiAudit = tiAudit;
    }

    public String getTiYqimg() {
        return tiYqimg;
    }

    public void setTiYqimg(String tiYqimg) {
        this.tiYqimg = tiYqimg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tiId=").append(tiId);
        sb.append(", tiTasknumber=").append(tiTasknumber);
        sb.append(", tiUsernumber=").append(tiUsernumber);
        sb.append(", tiTitle=").append(tiTitle);
        sb.append(", tiType=").append(tiType);
        sb.append(", tiMoney=").append(tiMoney);
        sb.append(", tiPeoplelimit=").append(tiPeoplelimit);
        sb.append(", tiDatelimit=").append(tiDatelimit);
        sb.append(", tiTimelimit=").append(tiTimelimit);
        sb.append(", tiTimeslimit=").append(tiTimeslimit);
        sb.append(", tiLink=").append(tiLink);
        sb.append(", tiDescribe=").append(tiDescribe);
        sb.append(", tiRequire=").append(tiRequire);
        sb.append(", tiCompletepeople=").append(tiCompletepeople);
        sb.append(", tiMsimg=").append(tiMsimg);
        sb.append(", tiPageview=").append(tiPageview);
        sb.append(", tiState=").append(tiState);
        sb.append(", tiDate=").append(tiDate);
        sb.append(", tiExperience=").append(tiExperience);
        sb.append(", tiAudit=").append(tiAudit);
        sb.append(", tiYqimg=").append(tiYqimg);
        sb.append("]");
        return sb.toString();
    }
}