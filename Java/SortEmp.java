import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;

class Employee{
    private String first_name;
    private String last_name;
    private String department;
    private String position;
    private int salary;

    public Employee(String firstName, String lastName, String department, String position, int salary) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public String getDepartment(){
        return department;
    }

    public int getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return first_name + " " + last_name + " | " + department + " | " + position + " | " + salary;
    }
}


public class SortEmp{

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("Employees.csv"));//read the csv file
            String line;
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                Employee employee = new Employee(data[0], data[1], data[2], data[3], (data.length>4)?parseSalary(data[4]):0);
                empList.add(employee);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(empList, Comparator.comparing(Employee::getDepartment)); //sort by department lexicographically

        Map<String, List<Employee>> deptMap = new LinkedHashMap<>(); //group rows by department
        for(Employee emp: empList){
            String department = emp.getDepartment();
            deptMap.computeIfAbsent(department, k -> new ArrayList<>()).add(emp);
        }

        for (Map.Entry<String, List<Employee>> entry : deptMap.entrySet()) {
            String department = entry.getKey();
            List<Employee> deptEmployees = entry.getValue();
            Collections.sort(deptEmployees, Comparator.comparingInt(Employee::getSalary)); //sort by salary
            System.out.println("Department: " + department);
            for(Employee emp : deptEmployees){
                System.out.println(emp.toString());
            }
            System.out.println();
        }

    }

    //method for preprocessing
    private static int parseSalary(String salaryString) {
        String numericString = salaryString.replaceAll("[^0-9.]", "");
        if(numericString.isEmpty()){
            return 0;
        }
        return Integer.parseInt(numericString);
    }
}