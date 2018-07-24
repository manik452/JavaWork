package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manik on 7/24/2018.
 */
public class Employee  implements Cloneable{

    private List<String> empList;

    public Employee() {
        this.empList = new ArrayList<>();
    }
    public Employee(List<String> empList) {
        this.empList = empList;
    }

    public List<String> getEmpList() {
        return empList;
    }

    public void setEmpList(List<String> empList) {
        this.empList = empList;
    }

    public void loadData(){
        empList.add("Pankaj");
        empList.add("adi");
        empList.add("fadi");
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> temp = new ArrayList<>();
        for(String s: this.getEmpList()){
            temp.add(s);
        }
        return new Employee(temp);
    }
}
