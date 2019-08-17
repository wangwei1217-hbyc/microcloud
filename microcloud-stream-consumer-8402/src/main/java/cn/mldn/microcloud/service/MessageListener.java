package cn.mldn.microcloud.service;

import cn.mldn.channel.DefaultProcess;
import cn.mldn.vo.Company;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
//@EnableBinding(Sink.class)
@EnableBinding(DefaultProcess.class)  //更换为自定义的消息通道定义
public class MessageListener {
//    @StreamListener(Sink.INPUT)
    @StreamListener(DefaultProcess.INPUT)
    public void input(Message<Company> message){
        System.err.println("【*****消息接收******】:"+message.getPayload());
    }
}
