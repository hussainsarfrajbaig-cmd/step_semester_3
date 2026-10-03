import java.util.*;
import java.time.LocalDate;

interface Plan {
    LocalDate getRenewalDate();
    String getName();
}

class Basic implements Plan {

    private String name;
    private LocalDate startDate;

    Basic(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }

    public String getName() {
        return name;
    }
}

class Standard implements Plan {

    private String name;
    private LocalDate startDate;

    Standard(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }

    public String getName() {
        return name;
    }
}

class Premium implements Plan {

    private String name;
    private LocalDate startDate;

    Premium(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }

    public String getName() {
        return name;
    }
}

public class StreamingRenewal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate =
                LocalDate.parse(date);

            Plan plan;

            if (type.equals("BASIC")) {

                plan = new Basic(
                    name,
                    startDate
                );
            }
            else if (type.equals("STANDARD")) {

                plan = new Standard(
                    name,
                    startDate
                );
            }
            else {

                plan = new Premium(
                    name,
                    startDate
                );
            }

            System.out.println(
                plan.getName() + ": "
                + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}
