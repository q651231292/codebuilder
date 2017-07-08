package com.rgy.test.action;

import com.rgy.test.model.Emp;
import java.util.HashMap;
import java.util.Map;

public class EmpAction {

    Map<String, Object> result;

    public boolean addEmp(Emp emp) {

        return true;
    }

    public boolean deleteEmp(Emp emp) {

        return true;
    }

    public boolean updateEmp(Emp emp) {

        return true;
    }

    public Map<String, Object> queryEmp(Emp emp) {
        result = new HashMap<>();

        return result;
    }
}
