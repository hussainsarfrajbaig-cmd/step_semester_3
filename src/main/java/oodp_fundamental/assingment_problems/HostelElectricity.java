import java.util.*;

interface Room {
    double calculateBill();
}

class SingleRoom implements Room {

    private double units;

    SingleRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8;
    }
}

class SharedRoom implements Room {

    private double units;
    private int occupants;

    SharedRoom(double units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6) / occupants;
    }
}

class ACRoom implements Room {

    private double units;

    ACRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        return (units * 10) + 200;
    }
}

public class HostelElectricity {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            Room room;

            if (type.equals("SINGLE")) {

                double units = sc.nextDouble();

                room = new SingleRoom(units);
            }
            else if (type.equals("SHARED")) {

                double units = sc.nextDouble();
                int occupants = sc.nextInt();

                room = new SharedRoom(
                    units,
                    occupants
                );
            }
            else {

                double units = sc.nextDouble();

                room = new ACRoom(units);
            }

            double bill = room.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                type,
                bill
            );

            total += bill;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}
