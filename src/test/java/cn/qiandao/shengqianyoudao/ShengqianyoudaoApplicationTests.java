package cn.qiandao.shengqianyoudao;

import cn.qiandao.shengqianyoudao.mapper.SkillRelationMapper;
import cn.qiandao.shengqianyoudao.pojo.Skilluserrelationship;
import cn.qiandao.shengqianyoudao.service.ISkillRelationService;
import cn.qiandao.shengqianyoudao.service.SkillsinfoService;
import cn.qiandao.shengqianyoudao.service.impl.SkillRelationServiceImpl;
import cn.qiandao.shengqianyoudao.util.DateTimeUntil;
import org.csource.fastdfs.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShengqianyoudaoApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SkillsinfoService skillsinfoService;
    @Autowired
    private ISkillRelationService iSkillRelationService;
    @Autowired
    private SkillRelationMapper skillRelationMapper;
    @Test
    public void insertTime(){
        SimpleDateFormat current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式"yyyy-MM-dd HH:mm:ss"
        System.out.println(current.format(new Date()));// new Date()为获取当前系统时间
        Skilluserrelationship skilluserrelationship = new Skilluserrelationship();
        skilluserrelationship.setSurId(0);
        skilluserrelationship.setSurUsernumber("yh10009");
        skilluserrelationship.setSurSkillnumber("jx10009");
        skilluserrelationship.setSurDate(DateTimeUntil.strToDate(current.format(new Date())));
        System.out.println(skilluserrelationship.toString());
        int insert = skillRelationMapper.insert(skilluserrelationship);
        List<Skilluserrelationship> skilluserrelationships = skillRelationMapper.selectAll();
//        skilluserrelationships.forEach(
//                skilluserrelationship1 -> System.out.println(skilluserrelationship1.getSurDate())
//        );
        for (Skilluserrelationship skilluserrelationship1 : skilluserrelationships) {
            System.out.println(DateTimeUntil.dateToStr(skilluserrelationship1.getSurDate()));
        }
        System.out.println(insert+"----");
        System.out.println(new Date());

    }
    @Test
    public void getMax(){
        String maxskill = skillsinfoService.getMaxskill();
        System.out.println(maxskill.toString());
    }

    @Test
    public void makeSkill(){
        String s = skillsinfoService.makeSkillID();
        System.out.println(s);
    }

    @Test
    public void contextLoads() throws Exception {
        ClientGlobal.init("E:/idea-code/shengqian/shengqianyoudao-1.git/src/main/resources/fdfs_client.conf");
        // 2、创建一个 TrackerClient 对象。直接 new 一个。
        TrackerClient trackerClient = new TrackerClient();
        // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 4、创建一个 StorageServer 的引用，值为 null
        StorageServer storageServer = null;
        // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer的引用
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 6、使用 StorageClient 对象上传图片。
        //扩展名不带“.”
        String[] strings = storageClient.upload_file("F:/deskimages/desk.jpg", "jpg",null);
        // 7、返回数组。包含组名和图片的路径。
        for (String string : strings) {
            System.out.println(string);
        }
    }


}
