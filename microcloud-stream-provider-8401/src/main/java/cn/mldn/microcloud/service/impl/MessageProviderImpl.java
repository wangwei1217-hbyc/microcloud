package cn.mldn.microcloud.service.impl;

import cn.mldn.channel.DefaultProcess;
import cn.mldn.microcloud.service.IMessageProvider;
import cn.mldn.vo.Company;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

//@EnableBinding(Source.class)  //可以理解为一个消息的发送管道的定义
@EnableBinding(DefaultProcess.class) //更换为自定义的消息通道
public class MessageProviderImpl implements IMessageProvider {

    @Qualifier(DefaultProcess.OUTPUT)  // 由于类型重复，所以设置一个标记
    @Resource
    MessageChannel output;  //消息的发送管道
    @Override
    public void send(Company company) {
        output.send(MessageBuilder.withPayload(company).build()); //创建并发送消息
    }
}
