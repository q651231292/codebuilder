package com.rgy.test.dao.impl;

import com.rgy.test.dao.EmpDao;
import com.rgy.test.model.Emp;
import java.util.HashMap;
import java.util.Map;

public class EmpDaoImpl implements EmpDao {

    Map<String, Object> result ;
    
    @Override
    public boolean addEmp(Emp emp) {

        return true;
    }

    @Override
    public boolean deleteEmp(Emp emp) {

        return true;
    }

    @Override
    public boolean updateEmp(Emp emp) {

        return true;
    }

    @Override
    public Map<String, Object> queryEmp(Emp emp) {
        result = new HashMap<>();

        return result;
    }

}
