import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int lowestPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            int profit = prices[i] - lowestPrice;

            if (profit > maximumProfit) {
                maximumProfit = profit;
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("Maximum Profit: " + maxProfit(prices));

        sc.close();
    }
}
