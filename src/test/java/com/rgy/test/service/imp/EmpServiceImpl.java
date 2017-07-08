package com.rgy.test.service.imp;

import com.rgy.test.dao.EmpDao;
import com.rgy.test.model.Emp;
import com.rgy.test.service.EmpService;
import java.util.Map;

public class EmpServiceImpl implements EmpService {

    EmpDao empDao;
    Map<String, Object> result;

    @Override
    public boolean addEmp(Emp emp) {
        boolean flg = empDao.addEmp(emp);
        return flg;
    }

    @Override
    public boolean deleteEmp(Emp emp) {
        boolean flg = empDao.deleteEmp(emp);
        return flg;
    }

    @Override
    public boolean updateEmp(Emp emp) {
        boolean flg = empDao.updateEmp(emp);
        return flg;
    }

    @Override
    public Map<String, Object> queryEmp(Emp emp) {
        result = empDao.queryEmp(emp);
        return result;
    }

}
