import java.util.*;

interface Delivery {
    double calculateFee();
}

class StandardDelivery implements Delivery {

    private double weight;
    private double distance;

    StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery implements Delivery {

    private double weight;
    private double distance;

    ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery implements Delivery {

    private double weight;
    private double distance;
    private double customsFee;

    InternationalDelivery(
        double weight,
        double distance,
        double customsFee
    ) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25
             + (2.00 * weight)
             + (0.50 * distance)
             + customsFee;
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            Delivery delivery;

            if (type.equals("STANDARD")) {

                double weight = sc.nextDouble();
                double distance = sc.nextDouble();

                delivery = new StandardDelivery(
                    weight,
                    distance
                );

            } 
            else if (type.equals("EXPRESS")) {

                double weight = sc.nextDouble();
                double distance = sc.nextDouble();

                delivery = new ExpressDelivery(
                    weight,
                    distance
                );

            } 
            else {

                double weight = sc.nextDouble();
                double distance = sc.nextDouble();
                double customsFee = sc.nextDouble();

                delivery = new InternationalDelivery(
                    weight,
                    distance,
                    customsFee
                );
            }

            double fee = delivery.calculateFee();

            System.out.printf(
                "%s: %.2f%n",
                type,
                fee
            );

            total += fee;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}
