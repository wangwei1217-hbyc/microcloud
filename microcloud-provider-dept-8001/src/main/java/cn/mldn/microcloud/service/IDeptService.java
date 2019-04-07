package cn.mldn.microcloud.service;

import cn.mldn.vo.Dept;

import java.util.List;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
public interface IDeptService {
    Dept get(long id) ;
    boolean add(Dept dept) ;
    List<Dept> list() ;
}
