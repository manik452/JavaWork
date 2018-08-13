import pattern.Employee;
import pattern.StructuralAdapterDesignPattern.SocketAdapter;
import pattern.StructuralAdapterDesignPattern.SocketObjectAdapterImpl;
import pattern.StructuralAdapterDesignPattern.Volt;
import pattern.builderDesign.Computer;
import templatepattern.GlassHouse;
import templatepattern.HouseTemplate;
import templatepattern.WoodenHouse;

import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {


        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        testTemplatePattern();
        prototypeDesignPattern();
        testClassAdapter();
        testObjectAdapter();

    }

    private static void testTemplatePattern() {
        HouseTemplate houseTemplate = new WoodenHouse();

        houseTemplate.buildHouse();
        houseTemplate = new GlassHouse();
        houseTemplate.buildHouse();
    }

    private static void testClassAdapter() {
    }
    private static void testObjectAdapter() {
        SocketAdapter socketAdapter = new SocketObjectAdapterImpl();

        Volt v3 = getVolt(socketAdapter, 3);
        Volt v12 = getVolt(socketAdapter, 12);
        Volt v120 = getVolt(socketAdapter, 120);

        System.out.println("V3 volts using Object Adapter: " + v3.getVolts());
        System.out.println("V12 volts using Object Adapter: " + v12.getVolts());
        System.out.println("V120 volts using Object Adapter: " + v120.getVolts());
    }

    private static Volt getVolt(SocketAdapter socketAdapter, int i) {
        switch (i){
            case 3: return socketAdapter.get3Volt();
            case 12: return socketAdapter.get12Volt();
            case 120: return socketAdapter.get120Volt();
            default: return socketAdapter.get3Volt();
        }
    }

    private static void prototypeDesignPattern() throws CloneNotSupportedException {
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
