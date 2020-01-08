package cn.qiandao.shengqianyoudao.service.impl;

import cn.qiandao.shengqianyoudao.mapper.VirtualMapper;
import cn.qiandao.shengqianyoudao.pojo.Virtualcurrencyrecords;
import cn.qiandao.shengqianyoudao.service.VirtualService;
import cn.qiandao.shengqianyoudao.util.IDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lxy
 * @date 2020/1/4 0004 18:46
 **/
@Service
public class VirtualServiceImpl implements VirtualService {
    private Logger log = LoggerFactory.getLogger(VirtualServiceImpl.class);
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private VirtualMapper virtualMapper;

    @Override
    public List<Virtualcurrencyrecords> getListVirtual(String vuid) {
        Virtualcurrencyrecords vcc = new Virtualcurrencyrecords();
        vcc.setVcrUserserialnumber(vuid);
        return virtualMapper.select(vcc);
    }

    @Override
    public int addVirtualcords(Virtualcurrencyrecords v) {
        v.setVcrTime(new Date());
        String virtual = (String) redisTemplate.opsForValue().get("金币");
        log.info("旧值是" + virtual);
        String jb = IDUtil.getNewEquipmentNo("jb", virtual);
        log.info("新值是" + virtual);
        redisTemplate.opsForValue().set("金币",jb);
        v.setVcrNumber(jb);
        return virtualMapper.insert(v);
    }

    @Override
    public int delVirtualcords(String vid) {
        Virtualcurrencyrecords vcc = new Virtualcurrencyrecords();
        vcc.setVcrNumber(vid);
        return virtualMapper.delete(vcc);
    }

    @Override
    public int updateVirtualcords(Virtualcurrencyrecords v) {
        return virtualMapper.updateByPrimaryKeySelective(v);
    }
}
