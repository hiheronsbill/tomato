package com.mk.java.xml;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/4 11:43
 * @Version V1.0
 **/
public class XMLTest {


    public static void main(String[] args) {

        objToString();
        String path = "user.xml";
//        objToFile(path);
//        fileToXml(path);

    }


    public static void objToString() {

        List<Computer> computers = Arrays.asList(new Computer("123", "QQQ", new Date(), 10000), new Computer("456", "WWW", new Date(), 20000));
        User user = new User(1, "Steven", "@sun123", new Date(), 1000,computers);
        // 将对象转为xml string
        String s = XMLUtil.convertToXml(user);
        System.out.println(s);
        System.out.println("--------------------------------------------------------------");
        // 将xml string转换为对象
        User user1 = XMLUtil.convertXmlToObject(User.class, s);
        System.out.println(user1);
    }

    public static void objToFile(String path){
        List<Computer> computers = Arrays.asList(new Computer("123", "QQQ", new Date(), 10000), new Computer("456", "WWW", new Date(), 20000));
        User user = new User(1, "Steven", "@sun123", new Date(), 1000,computers);
        // 将对象转为xml文件
        XMLUtil.convertToXml(user,path);
        System.out.println("-------------------------------------------------------------");
    }

    public static void fileToXml(String path){
        User user = XMLUtil.convertXmlFileToObject(User.class,path);
        System.out.println(user);
    }


}
