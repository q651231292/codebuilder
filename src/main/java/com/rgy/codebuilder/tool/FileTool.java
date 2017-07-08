/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.codebuilder.tool;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class FileTool {

    public static boolean write(String path, String fileName, String data) {
        System.out.println(path);
        System.out.println(fileName);

        File file = new File(path);
        //如果文件夹不存在则创建    
        if (!file.exists() && !file.isDirectory()) {
            boolean mkdirs = file.mkdirs(); // 创建多级目录
            if (mkdirs) {
                return write(path + "/" + fileName, data);
            }
        } else {
            return write(path + "/" + fileName, data);
        }
        return false;
    }

    private static boolean write(String path, String data) {
        try (PrintWriter pw = new PrintWriter(new File(path));) {
            pw.write(data);
            pw.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileTool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
