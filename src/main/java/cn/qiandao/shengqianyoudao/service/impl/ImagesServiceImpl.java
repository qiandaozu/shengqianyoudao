package cn.qiandao.shengqianyoudao.service.impl;

import cn.qiandao.shengqianyoudao.mapper.ImagesMapper;
import cn.qiandao.shengqianyoudao.pojo.Images;
import cn.qiandao.shengqianyoudao.service.IImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesServiceImpl implements IImagesService {
    @Autowired
    private ImagesMapper imagesMapper;
    @Override
    public String getImageAddress(String gameId) {
        Images images = new Images();
        images.setImId(gameId);
        Images reuultImages = imagesMapper.selectOne(images);
        return reuultImages.getImAddress();
    }
}
