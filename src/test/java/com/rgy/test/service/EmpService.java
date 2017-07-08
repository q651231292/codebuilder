package com.rgy.test.service;

import com.rgy.test.model.Emp;
import java.util.Map;

public interface EmpService {

    boolean addEmp(Emp emp);

    boolean deleteEmp(Emp emp);

    boolean updateEmp(Emp emp);

    Map<String, Object> queryEmp(Emp emp);
}
