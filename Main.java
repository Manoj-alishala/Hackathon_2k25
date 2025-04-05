import java.util.Scanner;

public class Main {

    public static int optimizeStorage(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W];
    }

    public static void fetchDataFromAPI() {
        System.out.println("\nSimulating API fetch for water data...");
        System.out.println("Data fetched successfully (simulated).\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        fetchDataFromAPI();

        System.out.print("Enter number of reservoirs: ");
        int n = scanner.nextInt();

        int[] capacities = new int[n];
        int[] importance = new int[n];

        System.out.println("\nEnter capacity (in million liters) and importance (priority score) for each reservoir:");
        for (int i = 0; i < n; i++) {
            System.out.print("Reservoir " + (i + 1) + " - Capacity: ");
            capacities[i] = scanner.nextInt();
            System.out.print("Reservoir " + (i + 1) + " - Importance: ");
            importance[i] = scanner.nextInt();
        }

        System.out.print("\nEnter total available water storage capacity: ");
        int totalCapacity = scanner.nextInt();

        System.out.println("\nOptimizing water storage using Knapsack algorithm...");
        int maxValue = optimizeStorage(totalCapacity, capacities, importance, n);

        System.out.println("Maximum Importance Achieved with Optimal Storage: " + maxValue);

        scanner.close();
    }
}
