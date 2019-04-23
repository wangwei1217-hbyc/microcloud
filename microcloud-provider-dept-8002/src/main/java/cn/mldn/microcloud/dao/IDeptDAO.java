package cn.mldn.microcloud.dao;

import cn.mldn.vo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@Mapper
public interface IDeptDAO {
    boolean doCreate(Dept vo);

    Dept findById(Long id);

    List<Dept> findAll();
}
