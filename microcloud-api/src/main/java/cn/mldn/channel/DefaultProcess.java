package cn.mldn.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义消息通道
 */
public interface DefaultProcess {
    public static final String OUTPUT = "my_output"; //输出通道名称
    public static final String INPUT = "my_input"; //输入通道名称

    @Output(DefaultProcess.OUTPUT)
    MessageChannel output();

    @Input(DefaultProcess.INPUT)
    SubscribableChannel input();

}
