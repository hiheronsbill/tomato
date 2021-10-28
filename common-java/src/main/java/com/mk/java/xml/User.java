package com.mk.java.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/4 11:02
 * @Version V1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "User")
@XmlType(propOrder = {
        "userId",
        "userName",
        "password",
        "birthday",
        "money",
        "computers"
})
public class User implements Serializable {
    private static final long serialVersionUID = 8000375715995880726L;

    private int userId;
    private String userName;
    private String password;
    private Date birthday;
    private double money;
    private List<Computer> computers;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", money=" + money +
                ", computers=" + computers +
                '}';
    }
}
