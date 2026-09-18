class Employeee {
    String empName;
    double salary;

    static String companyName =
            "Bright Horizon Technologies";

    static int employeeeCount = 0;

    Employeee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: "
                + employeeeCount);
    }

    public static void main(String[] args) {

        Employeee e1 =
                new Employeee("Divya", 65000);

        Employeee e2 =
                new Employeee("Arjun", 30000);

        Employeee e3 =
                new Employeee("Priya", 55000);

        Employeee.printCompanyInfo();
    }
}
