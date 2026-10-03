import java.util.*;

interface Employee {
    double calculateBonus();
    String getName();
}

class FullTime implements Employee {

    private String name;
    private double salary;

    FullTime(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }

    public String getName() {
        return name;
    }
}

class PartTime implements Employee {

    private String name;
    private double salary;

    PartTime(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }

    public String getName() {
        return name;
    }
}

class Intern implements Employee {

    private String name;
    private double salary;

    Intern(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return 2000;
    }

    public String getName() {
        return name;
    }
}

public class FestivalBonus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equals("FULLTIME")) {

                employee = new FullTime(
                    name,
                    salary
                );
            }
            else if (type.equals("PARTTIME")) {

                employee = new PartTime(
                    name,
                    salary
                );
            }
            else {

                employee = new Intern(
                    name,
                    salary
                );
            }

            double bonus = employee.calculateBonus();

            System.out.printf(
                "%s: %.2f%n",
                employee.getName(),
                bonus
            );

            total += bonus;
        }

        System.out.printf(
            "Total Bonus: %.2f%n",
            total
        );

        sc.close();
    }
}
