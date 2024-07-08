package com.passion.coding.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class MarshalTest {
    public static void main(String[] args) throws JAXBException {
        Employee e = new Employee();
        e.setEmployeeId("111");
        e.setEmployeeName("Reddy");
        e.setDesignation("SE");
        e.setSalary(2000000d);
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(e, new File("employee.xml"));
    }
}
