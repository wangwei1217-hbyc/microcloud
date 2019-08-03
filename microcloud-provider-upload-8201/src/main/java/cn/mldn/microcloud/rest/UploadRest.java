package cn.mldn.microcloud.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Created on 2019/5/10.
 */
@RestController
public class UploadRest {

    /**
     * 测试：curl -F "file=@F:/pictures/a.jpg" "http://root:root@upload.com:8201/upload"
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "fallback")
    public Object upload(@RequestParam("file") MultipartFile file){
        if(file != null){
            System.out.println("***【uploadRest】***:\n"+"文件名称:"+file.getOriginalFilename()
            +"\n文件大小："+file.getSize()+"字节");
            return "upload-"+ UUID.randomUUID().toString().replaceAll("-","")+ "." + FilenameUtils.getExtension(file.getOriginalFilename());
        }else{
            throw new IllegalArgumentException("没有上传文件");
        }

    }

    public Object fallback(@RequestParam("file") MultipartFile file){
        return "noFile.jpg";
    }
}
