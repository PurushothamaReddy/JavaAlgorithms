package com.passion.coding.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlType(propOrder = {"employeeId","employeeName","designation","salary"})
@XmlRootElement(name="Employee")
public class Employee {
    private String employeeId;
    private String employeeName;
    private String designation;
    private Double salary;

}
