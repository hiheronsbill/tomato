package com.mk.java.outputstream;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/25 12:26
 * @Version V1.0
 **/
public class FileOutput {


    public static void main(String[] args) {

        int i = 0;
        FileOutputStream fos = null;
        File file;
        long length = 0l;
        try {
            file = new File("/Users/heronsbill/logs/test.log");
            fos = new FileOutputStream(file);
            while (true) {
                Thread.sleep(10l);
                System.out.println(length == file.length());
                System.out.println(file.length());
                fos.write((i++ + "--aaaaaaaaaaaaaaaa").getBytes());
                fos.flush();
                length = file.length();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
