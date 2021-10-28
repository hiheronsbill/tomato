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

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/4 12:06
 * @Version V1.0
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "Computer")
@XmlType(propOrder = {
        "serialNumber",
        "brandName",
        "produceDate",
        "price"
})
public class Computer implements Serializable {
    private static final long serialVersionUID = -7577923508947089217L;

    private String serialNumber;
    private String brandName;
    private Date produceDate;
    private double price;

    @Override
    public String toString() {
        return "Computer{" +
                "serialNumber='" + serialNumber + '\'' +
                ", brandName='" + brandName + '\'' +
                ", produceDate=" + produceDate +
                ", price=" + price +
                '}';
    }
}
