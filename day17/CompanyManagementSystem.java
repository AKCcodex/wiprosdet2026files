package day17;
import java.util.*;
import java.util.stream.*;

// TechCorp Smart Employee Management System

// SECTION 1: INTERFACES

interface Taxable {

    static double calculateTax(double salary) {
        if (salary <= 50000) {
            return salary * 0.10;
        } else {
            return (50000 * 0.10) + ((salary - 50000) * 0.20);
        }
    }

    double getNetSalary();
}

interface Reportable {

    String getEmployeeType();

    default String generateReport() {
        return "[" + getEmployeeType() + "]";
    }
}

// SECTION 2: CUSTOM EXCEPTIONS

class InvalidSalaryException extends Exception {

    public InvalidSalaryException(String message) {
        super(message);
    }
}

class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

// SECTION 3: ABSTRACT CLASS

abstract class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private String department;
    protected double baseSalary;

    public Employee(int id, String name, String department, double baseSalary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateBonus();

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.baseSalary, other.baseSalary);
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | %s | Dept: %s | Base: %.2f | Bonus: %.2f",
                id,
                name,
                department,
                baseSalary,
                calculateBonus()
        );
    }
}

// SECTION 4: CONCRETE SUBCLASSES

class FullTimeEmployee extends Employee implements Taxable, Reportable {

    public FullTimeEmployee(int id, String name, String department, double baseSalary) {
        super(id, name, department, baseSalary);
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.20;
    }

    @Override
    public double getNetSalary() {
        return baseSalary + calculateBonus() - Taxable.calculateTax(baseSalary);
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time Employee";
    }

    @Override
    public String generateReport() {
        return Reportable.super.generateReport()
                + String.format(
                " | Tax: %.2f | Net Salary: %.2f",
                Taxable.calculateTax(baseSalary),
                getNetSalary()
        );
    }
}

class PartTimeEmployee extends Employee implements Reportable {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, String department,
                            int hoursWorked, double hourlyRate) {

        super(id, name, department, hoursWorked * hourlyRate);

        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.05;
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time Employee";
    }

    @Override
    public String generateReport() {
        return Reportable.super.generateReport()
                + String.format(
                " | Hours: %d @ %.2f/hr",
                hoursWorked,
                hourlyRate
        );
    }
}

class Contractor extends Employee implements Taxable, Reportable {

    private int contractDurationMonths;

    public Contractor(int id, String name, String department,
                      double baseSalary, int contractDurationMonths) {

        super(id, name, department, baseSalary);
        this.contractDurationMonths = contractDurationMonths;
    }

    public int getContractDurationMonths() {
        return contractDurationMonths;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.10;
    }

    @Override
    public double getNetSalary() {

        double contractorTax = baseSalary * 0.15;

        return baseSalary + calculateBonus() - contractorTax;
    }

    @Override
    public String getEmployeeType() {
        return "Contractor";
    }

    @Override
    public String generateReport() {
        return Reportable.super.generateReport()
                + String.format(
                " | Contract: %d months | Net: %.2f",
                contractDurationMonths,
                getNetSalary()
        );
    }
}

// SECTION 5: GENERIC CLASS

class DataStore<T> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(items);
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}

// SECTION 6: EMPLOYEE MANAGER

class EmployeeManager {

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) throws InvalidSalaryException {

        if (e.getBaseSalary() <= 0) {

            throw new InvalidSalaryException(
                    "Salary must be positive. Provided: "
                            + e.getBaseSalary()
                            + " for employee: "
                            + e.getName()
            );
        }

        employees.add(e);
    }

    public void removeEmployee(int id)
            throws EmployeeNotFoundException {

        Employee employee = findById(id);

        employees.remove(employee);

        System.out.println("Employee removed successfully: "
                + employee.getName());
    }

    public Employee findById(int id)
            throws EmployeeNotFoundException {

        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "No employee found with ID: " + id
                        ));
    }

    public List<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public HashMap<String, List<Employee>> getDepartmentMap() {

        HashMap<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees) {

            map.computeIfAbsent(
                    e.getDepartment(),
                    k -> new ArrayList<>()
            ).add(e);
        }

        return map;
    }

    public HashSet<String> getUniqueDepartments() {

        HashSet<String> set = new HashSet<>();

        for (Employee e : employees) {
            set.add(e.getDepartment());
        }

        return set;
    }

    public TreeMap<Double, String> getSortedBySalary() {

        TreeMap<Double, String> map = new TreeMap<>();

        for (Employee e : employees) {
            map.put(e.getBaseSalary(), e.getName());
        }

        return map;
    }

    public List<Employee> getEmployeesSortedByDesc() {

        return employees.stream()
                .sorted((e1, e2) ->
                        Double.compare(
                                e2.getBaseSalary(),
                                e1.getBaseSalary()
                        ))
                .collect(Collectors.toList());
    }

    public double getTotalPayroll() {

        return employees.stream()
                .mapToDouble(e ->
                        e.getBaseSalary() + e.calculateBonus())
                .sum();
    }

    public synchronized String generateFullReport() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n=========== FULL EMPLOYEE REPORT ===========\n");

        for (Employee e : employees) {

            sb.append(e.toString()).append("\n");

            if (e instanceof Reportable) {

                Reportable r = (Reportable) e;

                sb.append(r.generateReport()).append("\n");
            }

            sb.append("--------------------------------------------\n");
        }

        sb.append(String.format(
                "TOTAL PAYROLL: %.2f\n",
                getTotalPayroll()
        ));

        sb.append("============================================");

        return sb.toString();
    }
}

// SECTION 7: MULTITHREADING

class PayrollProcessor implements Runnable {

    private final EmployeeManager manager;
    private final String threadName;

    private static double totalProcessedAmount = 0.0;

    private static final Object LOCK = new Object();

    public PayrollProcessor(EmployeeManager manager, String threadName) {
        this.manager = manager;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        synchronized (LOCK) {

            System.out.println("[" + threadName
                    + "] Started payroll processing...");

            double payroll = manager.getTotalPayroll();

            totalProcessedAmount += payroll;

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(threadName
                        + " interrupted.");
            }

            System.out.printf(
                    "[%s] Payroll computed: ₹%.2f%n",
                    threadName,
                    payroll
            );
        }
    }

    public static double getTotalProcessedAmount() {
        return totalProcessedAmount;
    }
}

class ReportGenerator implements Runnable {

    private final EmployeeManager manager;

    public ReportGenerator(EmployeeManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {

        System.out.println(
                "[ReportGenerator] Generating report..."
        );

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(
                    "Report generation interrupted."
            );
        }

        System.out.println(manager.generateFullReport());
    }
}

// SECTION 8: MAIN CLASS

public class CompanyManagementSystem {

    public static void main(String[] args) {

        System.out.println("\n--------------------------------------");
        System.out.println("TechCorp Smart Employee Management System");
        System.out.println("--------------------------------------\n");

        String filterDept = null;

        if (args.length > 0) {

            filterDept = args[0];

            System.out.println(
                    "[CMD ARG] Department filter active: "
                            + filterDept
            );
        }

        EmployeeManager manager = new EmployeeManager();

        // STEP 1

        System.out.println("\n- 1. ADDING EMPLOYEES -");

        try {

            manager.addEmployee(
                    new FullTimeEmployee(
                            101,
                            "Alice Johnson",
                            "Engineering",
                            80000
                    )
            );

            manager.addEmployee(
                    new FullTimeEmployee(
                            102,
                            "Bob Smith",
                            "Engineering",
                            95000
                    )
            );

            manager.addEmployee(
                    new FullTimeEmployee(
                            103,
                            "Sneha Rao",
                            "Finance",
                            72000
                    )
            );

            manager.addEmployee(
                    new PartTimeEmployee(
                            104,
                            "Carol White",
                            "Marketing",
                            120,
                            250.0
                    )
            );

            manager.addEmployee(
                    new PartTimeEmployee(
                            105,
                            "David Lee",
                            "HR",
                            80,
                            300.0
                    )
            );

            manager.addEmployee(
                    new Contractor(
                            106,
                            "Eve Davis",
                            "Engineering",
                            70000,
                            12
                    )
            );

            manager.addEmployee(
                    new Contractor(
                            107,
                            "Frank Miller",
                            "Finance",
                            60000,
                            6
                    )
            );

            System.out.println(
                    "7 employees added successfully."
            );

            System.out.println(
                    "Testing InvalidSalaryException..."
            );

            manager.addEmployee(
                    new FullTimeEmployee(
                            999,
                            "Ghost",
                            "Unknown",
                            -5000
                    )
            );

        } catch (InvalidSalaryException e) {

            System.out.println(
                    "Caught InvalidSalaryException: "
                            + e.getMessage()
            );
        }

        // STEP 2

        System.out.println(
                "\n- 2. WRAPPER CLASSES & AUTOBOXING -"
        );

        Integer totalEmployees =
                manager.getAllEmployees().size();

        int primitiveCount = totalEmployees;

        Double maxSalary = manager.getAllEmployees()
                .stream()
                .map(Employee::getBaseSalary)
                .max(Double::compare)
                .orElse(0.0);

        double parsedValue =
                Double.parseDouble("9999.99");

        System.out.println(
                "Total Employees (Integer): "
                        + totalEmployees
        );

        System.out.println(
                "Primitive employee count: "
                        + primitiveCount
        );

        System.out.println(
                "Max Base Salary: "
                        + maxSalary
        );

        System.out.println(
                "Parsed Double: "
                        + parsedValue
        );

        System.out.println(
                "Integer.MAX_VALUE: "
                        + Integer.MAX_VALUE
        );

        System.out.println(
                "Double.MIN_VALUE: "
                        + Double.MIN_VALUE
        );

        // STEP 3

        System.out.println(
                "\n- 3. STRING & STRINGBUILDER -"
        );

        String companyName = "   TechCorp Pvt. Ltd.   ";

        System.out.println(
                "trim(): " + companyName.trim()
        );

        System.out.println(
                "toUpperCase(): "
                        + companyName.toUpperCase()
        );

        System.out.println(
                "substring(0,8): "
                        + companyName.trim().substring(0, 8)
        );

        System.out.println(
                "contains(\"Corp\"): "
                        + companyName.contains("Corp")
        );

        System.out.println(
                "replace(): "
                        + companyName.replace(
                        "TechCorp",
                        "TC"
                )
        );

        StringBuilder summary = new StringBuilder();

        summary.append("Company Summary | Employees: ")
                .append(manager.getAllEmployees().size())
                .append(" | Payroll: ₹")
                .append(String.format(
                        "%.2f",
                        manager.getTotalPayroll()
                ));

        System.out.println(summary);

        // STEP 4

        System.out.println(
                "\n- 4. DEPARTMENT MAP (HashMap) -"
        );

        HashMap<String, List<Employee>> deptMap =
                manager.getDepartmentMap();

        deptMap.forEach((dept, empList) -> {

            if (filterDept == null
                    || dept.equalsIgnoreCase(filterDept)) {

                System.out.println("\nDepartment: " + dept);

                empList.forEach(emp ->
                        System.out.println(
                                " - " + emp.getName()
                        ));
            }
        });

        // STEP 5

        System.out.println(
                "\n- 5. UNIQUE DEPARTMENTS (HashSet) -"
        );

        HashSet<String> departments =
                manager.getUniqueDepartments();

        System.out.println(departments);

        // STEP 6

        System.out.println(
                "\n- 6. SALARY SORTED ASCENDING (TreeMap) -"
        );

        TreeMap<Double, String> salaryMap =
                manager.getSortedBySalary();

        salaryMap.forEach((salary, name) ->
                System.out.printf(
                        "%s -> %.2f%n",
                        name,
                        salary
                ));

        // STEP 7

        System.out.println(
                "\n- 7. NATURAL SORT Comparable (Salary Asc) -"
        );

        List<Employee> sortedEmployees =
                new ArrayList<>(manager.getAllEmployees());

        Collections.sort(sortedEmployees);

        for (Employee e : sortedEmployees) {

            System.out.printf(
                    "%s -> %.2f%n",
                    e.getName(),
                    e.getBaseSalary()
            );
        }

        // STEP 8

        System.out.println(
                "\n- 8. COMPARATOR SORT + Lambda (Salary Desc) -"
        );

        List<Employee> descEmployees =
                manager.getEmployeesSortedByDesc();

        descEmployees.forEach(e ->
                System.out.printf(
                        "%s -> %.2f%n",
                        e.getName(),
                        e.getBaseSalary()
                ));

        // STEP 9

        System.out.println(
                "\n- 9. TAX CALCULATION (Static Interface Method) -"
        );

        manager.getAllEmployees()
                .stream()
                .filter(e -> e instanceof Taxable)
                .forEach(e -> {

                    Taxable t = (Taxable) e;

                    System.out.printf(
                            "%s | Tax: %.2f | Net: %.2f%n",
                            e.getName(),
                            Taxable.calculateTax(
                                    e.getBaseSalary()
                            ),
                            t.getNetSalary()
                    );
                });

        // STEP 10

        System.out.println(
                "\n- 10. EXCEPTION HANDLING -"
        );

        try {

            manager.findById(999);

        } catch (EmployeeNotFoundException e) {

            System.out.println(
                    e.getMessage()
            );
        }

        try {

            manager.removeEmployee(104);

        } catch (EmployeeNotFoundException e) {

            System.out.println(
                    e.getMessage()
            );
        }

        // STEP 11

        System.out.println(
                "\n- 11. GENERIC DATASTORE -"
        );

        DataStore<String> stringStore =
                new DataStore<>();

        stringStore.add("Java");
        stringStore.add("Spring Boot");
        stringStore.add("Multithreading");
        stringStore.add("Data Structures");

        DataStore<Integer> integerStore =
                new DataStore<>();

        integerStore.add(101);
        integerStore.add(102);
        integerStore.add(106);

        DataStore<Employee> employeeStore =
                new DataStore<>();

        for (Employee e : manager.getAllEmployees()) {
            employeeStore.add(e);
        }

        System.out.println(
                "String Store: " + stringStore
        );

        System.out.println(
                "Integer Store: " + integerStore
        );

        System.out.println(
                "Employee Store: " + employeeStore
        );

        // STEP 12

        System.out.println(
                "\n- 12. MULTITHREADING -"
        );

        Thread t1 = new Thread(
                new PayrollProcessor(
                        manager,
                        "PayrollThread-1"
                )
        );

        Thread t2 = new Thread(
                new PayrollProcessor(
                        manager,
                        "PayrollThread-2"
                )
        );

        Thread t3 = new Thread(
                new ReportGenerator(manager)
        );

        t1.start();
        t2.start();
        t3.start();

        try {

            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {

            System.out.println(
                    "Main thread interrupted."
            );
        }

        System.out.printf(
                "\nFinal Total Processed Amount: ₹%.2f%n",
                PayrollProcessor.getTotalProcessedAmount()
        );

        System.out.println(
                "\n--------------------------------------"
        );

        System.out.println(
                "EXECUTION COMPLETE"
        );

        System.out.println(
                "--------------------------------------"
        );
    }
}