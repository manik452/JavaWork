import pattern.Employee;
import pattern.StructuralAdapterDesignPattern.SocketAdapter;
import pattern.StructuralAdapterDesignPattern.SocketObjectAdapterImpl;
import pattern.StructuralAdapterDesignPattern.Volt;
import pattern.builderDesign.Computer;
import pattern.chainofresponsibility.ATMDispenseChain;
import pattern.chainofresponsibility.Currency;
import pattern.mediator.ChatMediator;
import pattern.mediator.ChatMediatorImpl;
import pattern.mediator.User;
import pattern.mediator.UserImpl;
import pattern.templatepattern.GlassHouse;
import pattern.templatepattern.HouseTemplate;
import pattern.templatepattern.WoodenHouse;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {


        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        dispenseChainPattern();
        mediatorBehavioralPattern();
        testTemplatePattern();
        prototypeDesignPattern();
        testClassAdapter();
        testObjectAdapter();

    }

    private static void dispenseChainPattern(){
        ATMDispenseChain dispenseChain = new ATMDispenseChain();

        while (true){
            int amount =0;
            System.out.println("Enter Amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();

            if(amount %10 != 0){
                System.out.println("Amont Should Be in multiple of 10s");
                return;
            }
            dispenseChain.chain1.dispense(new Currency(amount));
        }
    }

    private static void mediatorBehavioralPattern() {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator,"Pankaj");
        User user2 = new UserImpl(mediator,"sagor");
        User user3 = new UserImpl(mediator,"Nodi");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.send("Hi All");
        user2.send("Hi 2");
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
