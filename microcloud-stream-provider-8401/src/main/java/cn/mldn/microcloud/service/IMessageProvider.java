package cn.mldn.microcloud.service;

import cn.mldn.vo.Company;
import cn.mldn.vo.Dept;

import java.util.List;


public interface IMessageProvider {
    /**
     * 实现消息的发送，本次发送的消息是一个对象(自动变为json)
     * @param company
     */
    void send(Company company);
}
