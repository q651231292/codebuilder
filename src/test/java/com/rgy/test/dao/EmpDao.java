package com.rgy.test.dao;

import com.rgy.test.model.Emp;
import java.util.Map;

public interface EmpDao {
    
    boolean addEmp(Emp emp) ;

    boolean deleteEmp(Emp emp) ;

    boolean updateEmp(Emp emp) ;

    Map<String, Object> queryEmp(Emp emp);
}
