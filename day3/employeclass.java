package day3;

public class employeclass {

    static class Employee {
        private String name;
        private double salary;

        // Constructor
        Employee(String name, double salary) {
            this.name = name;
            setSalary(salary);
        }

        // Setter
        public void setSalary(double salary) {
            if (salary > 0) {
                this.salary = salary;
            } else {
                System.out.println("Invalid salary");
            }
        }

        // Getter
        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {

        double sa = 4000;

        // Create object
        Employee emp = new Employee("Ashish", sa);

        // Access data
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: " + emp.getSalary());
    }
}