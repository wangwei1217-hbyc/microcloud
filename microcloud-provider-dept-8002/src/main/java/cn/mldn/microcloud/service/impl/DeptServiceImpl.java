package cn.mldn.microcloud.service.impl;

import cn.mldn.microcloud.dao.IDeptDAO;
import cn.mldn.microcloud.service.IDeptService;
import cn.mldn.vo.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Resource
    private IDeptDAO deptDAO;

    @Override
    public Dept get(long id) {
        return deptDAO.findById(id);
    }

    @Override
    public boolean add(Dept dept) {
        return deptDAO.doCreate(dept);
    }

    @Override
    public List<Dept> list() {
        return deptDAO.findAll();
    }
}
