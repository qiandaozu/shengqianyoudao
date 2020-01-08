package cn.qiandao.shengqianyoudao.mapper;

import cn.qiandao.shengqianyoudao.pojo.Taskinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskinfoMapper {
    /**
     * 查询任务详情页信息
     *
     * @param tiid 任务id
     * @return 任务对象
     */
//    @Select("select * from taskinfo where ti_id=#{tiid}")
    Taskinfo selectBytitasknumber(@Param("tiid") int tiid);


    Taskinfo selectByTiTitle(@Param("tiid") int tiid);
}