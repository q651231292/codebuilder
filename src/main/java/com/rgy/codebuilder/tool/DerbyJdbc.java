/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.codebuilder.tool;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DerbyJdbc {

    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:";
    String dbName = "db";
//    String dbName = "D:\\Workspaces\\netbeans\\codebuilder\\db0";
    Connection conn = null;
    Statement s = null;
    ResultSet rs = null;
    private ResultSetMetaData md;
    private PreparedStatement ps;
    private Properties prop;
    private String url;
    private String user;
    private String psw;
    private List<Map<String, Object>> list;
    private Map<String, Object> map;
    private Integer flg;
    private FileInputStream fis;

    static void loadDriver() {
        try {
            System.out.println("驱动程序-开始加载");
            Class.forName(driver).newInstance();
            System.out.println("驱动程序-加载完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection open() {

        System.out.println("数据库-正在连接");
        try {
            conn = DriverManager.getConnection(protocol + dbName + ";create=true");
        } catch (SQLException e) {
            e.printStackTrace();
            

        }

        System.out.println(dbName + "-已连接");
        return conn;
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
                System.out.println("预先声明-关闭");
            }
            if (rs != null) {
                rs.close();
                System.out.println("结果集-关闭");
            }
            if (conn != null) {
                conn.close();
                System.out.println("连接-关闭");
            }
             
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List query(String sql, Object... objs) {
        loadDriver();
        conn = open();
        list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            rs = ps.executeQuery();
            md = rs.getMetaData();
            while (rs.next()) {
                map = new HashMap<>();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    String key = md.getColumnName(i);
                    Object value = rs.getObject(i);
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            close(conn, ps, rs);
            
        }
        return list;
    }

    public int dml(String sql, Object... objs) {
        open();
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            flg = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return flg;
    }

    /**
     * 添加数据
     *
     * @param sql 添加语句
     * @param objs 参数
     * @return 0失败 1成功
     */
    public int add(String sql, Object... objs) {
        flg = dml(sql, objs);
        return flg;
    }

    /**
     * 修改数据
     *
     * @param sql 修改语句
     * @param objs 参数
     * @return 0失败 1成功
     */
    public int mod(String sql, Object... objs) {
        flg = dml(sql, objs);
        return flg;
    }

    /**
     * 删除数据
     *
     * @param sql 删除语句
     * @param objs 参数
     * @return 0失败 1成功
     */
    public int del(String sql, Object... objs) {
        flg = dml(sql, objs);
        return flg;
    }

    public boolean tableIsNotExists(String table) {
        conn = open();
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rsTables = meta.getTables(dbName, null, table, new String[]{"TABLE"});
            while (rsTables.next()) {
                String tableName = rsTables.getString("TABLE_NAME");
                if (table.toUpperCase().equals(tableName)) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DerbyJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return true;
    }

}
