package com.mk.java.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @Desc 封装XML转换成object，object转换成XML代码
 * @Author zhxy
 * @Date 2021/9/4 11:08
 * @Version V1.0
 **/
public class XMLUtil {

    /**
     * 将对象直接转换成String类型的XML输出
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        StringWriter writer = new StringWriter();
        try {
            // 利用jdk自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    /**
     * 将对象根据路径转换成xml文件
     *
     * @param obj
     * @param path
     */
    public static void convertToXml(Object obj, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            FileWriter fw = null;
            try {
                fw = new FileWriter(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            marshaller.marshal(obj, fw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将string类型的xml转换成对象
     *
     * @param clazz
     * @param xmlString
     * @return
     */
    public static <T>T convertXmlToObject(Class<T> clazz, String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将xml转换成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlString);
            return (T)unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将file类型的xml转换成对象
     *
     * @param clazz
     * @param xmlPath
     * @return
     */
    public static <T>T convertXmlFileToObject(Class<T> clazz, String xmlPath) {

        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            FileReader fr = null;
            try {
                fr = new FileReader(xmlPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return (T)unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


}
