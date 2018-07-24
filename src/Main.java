import pattern.Employee;
import pattern.builderDesign.Computer;

import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {


        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        Employee employee = new Employee();
        employee.loadData();

        Employee employee1 = (Employee) employee.clone();
        Employee employee2 = (Employee) employee.clone();

        List<String> list = employee1.getEmpList();
        list.add("TestAdd");

        Employee employee3 = new Employee(list);

        List<String> list2 = employee2.getEmpList();
        list2.remove("Pankaj");

        System.out.println("Hello World!"+ employee.getEmpList());
        System.out.println("Hello World!"+ list);
        System.out.println("Hello World!"+ list2);
        System.out.println("Hello World!"+ employee3.getEmpList());
    }
}
