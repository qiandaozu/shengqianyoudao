package cn.qiandao.shengqianyoudao.pojo;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "images")
public class Images {
    @Column(name = "id")
    private Integer imagesId;
    @Column(name = "im_id")
    private String imId;
    @Column(name = "im_address")
    private String imAddress;
}
