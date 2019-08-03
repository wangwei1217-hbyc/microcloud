package cn.mldn.microcloud.controller;

import org.apache.commons.lang.CharSet;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.Charset;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@Controller
public class ConsumerUploadController {
//    public static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get/";
    // 设置要进行远程上传微服务调用的代理地址
    public static final String UPLOAD_URL = "http://gateway-9501.com:9501/zuul/upload-proxy/upload";

    @RequestMapping(value = "/uploadPre",method = RequestMethod.GET)
    public String uploadPre(){
        return "upload";
    }

    @RequestMapping(value = "/consumer/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(String name,@RequestParam("file") MultipartFile file) throws Exception{
        if(file != null){
            CloseableHttpClient httpClient = HttpClients.createDefault(); //创建一个HttpClient对象
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider(); //创建一个具有认证访问的信息
            Credentials credentials = new UsernamePasswordCredentials("zdmin","zdmin"); //创建一条认证操作信息
            credentialsProvider.setCredentials(AuthScope.ANY,credentials); //所有的认证请求都是用同一个认证信息
            HttpClientContext httpClientContext = HttpClientContext.create(); //创建Http处理操作的上下文对象
            httpClientContext.setCredentialsProvider(credentialsProvider); //设置提供的认证信息
            HttpPost httpPost = new HttpPost(UPLOAD_URL); //设置要进行访问的请求地址
            HttpEntity entity = MultipartEntityBuilder.create()
                    .addBinaryBody("file",file.getBytes(), ContentType.create("image/jpeg"),"temp.jpg")
                    .build();
            httpPost.setEntity(entity); //设置请求的实体信息
            HttpResponse response = httpClient.execute(httpPost, httpClientContext); //执行请求的发送
            return EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
//            return "【*** 消费端 ***】name = " + name + "、photoName = "
//					+ file.getOriginalFilename() + "、ContentType = "
//					+ file.getContentType();
        }
        return "noFile";
    }

}
