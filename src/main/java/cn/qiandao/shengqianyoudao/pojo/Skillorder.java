package cn.qiandao.shengqianyoudao.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "skillorder")
public class Skillorder implements Serializable {
    /**
    * id
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer soId;

    /**
    * 订单编号
    */
    @Column(name = "so_number")
    private String soNumber;

    /**
    * 技能编号
    */
    @Column(name = "so_Skill")
    private String soSkillnumber;

    /**
    * 购买技能的用户编号
    */
    private String soBuyusernumber;

    /**
    * 购买时间
    */
    private Date soPurchasingdate;

    private Date soEnddate;

    /**
    * 数量
    */
    private Integer soQuantity;

    /**
    * 金额
    */
    private Long soMoney;

    /**
    * 付款方式（填写序号）
    */
    private Integer soPaymentmethod;

    /**
    * 订单状态（填写序号）
    */
    private Integer soState;

    private static final long serialVersionUID = 1L;

    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }

    public String getSoSkillnumber() {
        return soSkillnumber;
    }

    public void setSoSkillnumber(String soSkillnumber) {
        this.soSkillnumber = soSkillnumber;
    }

    public String getSoBuyusernumber() {
        return soBuyusernumber;
    }

    public void setSoBuyusernumber(String soBuyusernumber) {
        this.soBuyusernumber = soBuyusernumber;
    }

    public Date getSoPurchasingdate() {
        return soPurchasingdate;
    }

    public void setSoPurchasingdate(Date soPurchasingdate) {
        this.soPurchasingdate = soPurchasingdate;
    }

    public Date getSoEnddate() {
        return soEnddate;
    }

    public void setSoEnddate(Date soEnddate) {
        this.soEnddate = soEnddate;
    }

    public Integer getSoQuantity() {
        return soQuantity;
    }

    public void setSoQuantity(Integer soQuantity) {
        this.soQuantity = soQuantity;
    }

    public Long getSoMoney() {
        return soMoney;
    }

    public void setSoMoney(Long soMoney) {
        this.soMoney = soMoney;
    }

    public Integer getSoPaymentmethod() {
        return soPaymentmethod;
    }

    public void setSoPaymentmethod(Integer soPaymentmethod) {
        this.soPaymentmethod = soPaymentmethod;
    }

    public Integer getSoState() {
        return soState;
    }

    public void setSoState(Integer soState) {
        this.soState = soState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", soId=").append(soId);
        sb.append(", soNumber=").append(soNumber);
        sb.append(", soSkillnumber=").append(soSkillnumber);
        sb.append(", soBuyusernumber=").append(soBuyusernumber);
        sb.append(", soPurchasingdate=").append(soPurchasingdate);
        sb.append(", soEnddate=").append(soEnddate);
        sb.append(", soQuantity=").append(soQuantity);
        sb.append(", soMoney=").append(soMoney);
        sb.append(", soPaymentmethod=").append(soPaymentmethod);
        sb.append(", soState=").append(soState);
        sb.append("]");
        return sb.toString();
    }
}