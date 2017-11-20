package com.lys.ddshop.service.impl;

import com.lys.ddshop.common.util.FtpUtils;
import com.lys.ddshop.common.util.IDUtils;
import com.lys.ddshop.common.util.PropKit;
import com.lys.ddshop.service.FileService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/17
 * Time: 19:47
 * Version:V1.0
 */
@Service
public class FileServiceImpl implements FileService{
    @Override
    public Map<String, Object> uploadImages(MultipartFile upfile) {

        String name="ftp.properties";
        String host= PropKit.use(name).get("ftp.address");
        int post=PropKit.use(name).getInt("ftp.port");
        String username = PropKit.use(name).get("ftp.username");
        String password = PropKit.use(name).get("ftp.password");
        String basePath = PropKit.use(name).get("ftp.basePath");
        String filePath = new DateTime().toString("/yyyy/MM/dd");
        //获取原来的文件名，包括扩展名
        String original = upfile.getOriginalFilename();
        //截取出扩展名
        String fileType = original.substring(original.lastIndexOf("."));
        //使用自定义工具类产生新的文件名，只产生了文件名，未产生扩展名
        String filename = IDUtils.genImageName();
        //拼接出新的文件名+扩展名
        filename += fileType;
        InputStream input = null;
        try {
            input = upfile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean bool = FtpUtils.uploadFile(host,post,username,password,basePath,filePath,filename,input);
        //System.out.println(host+post+username+password+basePath+filePath+filename+input);
        Map<String,Object> map = new HashMap<String,Object>();
        if(bool){
            map.clear();
            map.put("state","SUCCESS");
            map.put("original",original);
            map.put("size",upfile.getSize());
            map.put("title",filename);
            map.put("type",fileType);
            map.put("url",filePath + "/" + filename);
            //System.out.println(map);
        }
        return map;

    }
}
