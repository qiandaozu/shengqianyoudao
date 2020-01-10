package cn.qiandao.shengqianyoudao.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@ToString
@Table(name = "taskorder")
public class Taskorder implements Serializable {
    /**
     * id
     */
    private Integer toId;

    /**
     * 任务编号
     */
    private String toTasknumber;

    /**
     * 发布任务的用户编号
     */
    private String toReleaseusernumber;

    /**
     * 接取任务的用户编号
     */
    private String toAccpetusernumber;

    /**
     * 接受时间
     */
    private Date toAccpetdate;

    /**
     * 最后更改时间
     */
    private Date toUpdate;

    /**
     * 数量
     */
    private Integer toQuantity;

    /**
     * 金额
     */
    private Long toMoney;

    /**
     * 订单编号
     */
    private String toNumber;

    /**
     * 订单状态（填写序号）
     */
    private Integer toState;

    private static final long serialVersionUID = 1L;

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getToTasknumber() {
        return toTasknumber;
    }

    public void setToTasknumber(String toTasknumber) {
        this.toTasknumber = toTasknumber;
    }

    public String getToReleaseusernumber() {
        return toReleaseusernumber;
    }

    public void setToReleaseusernumber(String toReleaseusernumber) {
        this.toReleaseusernumber = toReleaseusernumber;
    }

    public String getToAccpetusernumber() {
        return toAccpetusernumber;
    }

    public void setToAccpetusernumber(String toAccpetusernumber) {
        this.toAccpetusernumber = toAccpetusernumber;
    }

    public Date getToAccpetdate() {
        return toAccpetdate;
    }

    public void setToAccpetdate(Date toAccpetdate) {
        this.toAccpetdate = toAccpetdate;
    }

    public Date getToUpdate() {
        return toUpdate;
    }

    public void setToUpdate(Date toUpdate) {
        this.toUpdate = toUpdate;
    }

    public Integer getToQuantity() {
        return toQuantity;
    }

    public void setToQuantity(Integer toQuantity) {
        this.toQuantity = toQuantity;
    }

    public Long getToMoney() {
        return toMoney;
    }

    public void setToMoney(Long toMoney) {
        this.toMoney = toMoney;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    public Integer getToState() {
        return toState;
    }

    public void setToState(Integer toState) {
        this.toState = toState;
    }
}