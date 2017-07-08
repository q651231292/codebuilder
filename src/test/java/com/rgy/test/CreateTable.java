/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.test;

import com.rgy.codebuilder.tool.DerbyJdbc;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class CreateTable {

    public CreateTable() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        System.out.println(11);
    }

    @Test
    public void droptemp() {
        DerbyJdbc dj = new DerbyJdbc();
        String sql = "";
        sql += "drop table temp";
        dj.dml(sql);
    }

    @Test
    public void createtemp() {
        DerbyJdbc dj = new DerbyJdbc();
        String sql = "";
        sql += "create table temp("
                + "    id varchar(36) primary key,"
                + "    name varchar(32672),"
                + "    action varchar(32672),"
                + "    service varchar(32672),"
                + "    serviceImpl varchar(32672),"
                + "    dao varchar(32672),"
                + "    daoImpl varchar(32672)"
                + ")";
        dj.dml(sql);
    }

    @Test
    public void inserttemp() {
        DerbyJdbc dj = new DerbyJdbc();
        String sql = "";
        String action = getAction();
        String service = getService();
        String serviceImpl = getServiceImpl();
        String dao = getDao();
        String daoImpl = getDaoImpl();
        String id = UUID.randomUUID().toString();
        sql += "insert into temp values('"+id+"','temp"+id+"',?,?,?,?,?)";

        dj.dml(sql, action, service, serviceImpl, dao, daoImpl);
    }

    @Test
    public void querytemp() {
        DerbyJdbc dj = new DerbyJdbc();
        List list = dj.query("select * from temp");
        list.forEach((Object obj) -> {
            Map<String, Object> map = (Map<String, Object>) obj;
            Object dao = map.get("DAO");
        });
        System.out.println(list);
    }

    private String getAction() {
        String action = "package com.rgy.test.action;\n"
                + "\n"
                + "import com.rgy.test.model.Emp;\n"
                + "import java.util.HashMap;\n"
                + "import java.util.Map;\n"
                + "\n"
                + "public class EmpAction {\n"
                + "\n"
                + "    Map<String, Object> result;\n"
                + "\n"
                + "    public boolean addEmp(Emp emp) {\n"
                + "\n"
                + "        return true;\n"
                + "    }\n"
                + "\n"
                + "    public boolean deleteEmp(Emp emp) {\n"
                + "\n"
                + "        return true;\n"
                + "    }\n"
                + "\n"
                + "    public boolean updateEmp(Emp emp) {\n"
                + "\n"
                + "        return true;\n"
                + "    }\n"
                + "\n"
                + "    public Map<String, Object> queryEmp(Emp emp) {\n"
                + "        result = new HashMap<>();\n"
                + "\n"
                + "        return result;\n"
                + "    }\n"
                + "}\n"
                + "";
        return action;
    }

    private String getService() {
        String service = "";
        return service;
    }

    private String getServiceImpl() {
        String serviceImpl = "";
        return serviceImpl;
    }

    private String getDao() {
        String dao = "package com.rgy.test.dao;\n" +
"\n" +
"import com.rgy.test.model.Emp;\n" +
"import java.util.Map;\n" +
"\n" +
"public interface EmpDao {\n" +
"    \n" +
"    boolean addEmp(Emp emp) ;\n" +
"\n" +
"    boolean deleteEmp(Emp emp) ;\n" +
"\n" +
"    boolean updateEmp(Emp emp) ;\n" +
"\n" +
"    Map<String, Object> queryEmp(Emp emp);\n" +
"}\n" +
"";
        return dao;
    }

    private String getDaoImpl() {
        String daoImpl = "";
        return daoImpl;
    }

}
