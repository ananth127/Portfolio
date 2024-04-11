import java.util.Scanner;

public class PotionBrewing {

    public static int maxCombinedPotency(int N, int[] quantity, int[] potency, int[][] required) {
        int maxPotency = 0;

        // Try brewing each potion and calculate the combined potency
        for (int potionIdx = 0; potionIdx < N; potionIdx++) {
            // Check if we can brew this potion with available ingredients
            boolean canBrew = true;
            int combinedPotency = 0;

            for (int ingredientIdx = 0; ingredientIdx < N; ingredientIdx++) {
                int requiredQuantity = required[ingredientIdx][potionIdx];
                if (requiredQuantity > quantity[ingredientIdx]) {
                    canBrew = false;
                    break;  // Not enough ingredient available for this potion
                }
                combinedPotency += potency[ingredientIdx] * requiredQuantity;
            }

            // Update maxPotency if this potion can be brewed
            if (canBrew) {
                maxPotency = Math.max(maxPotency, combinedPotency);
            }
        }

        return maxPotency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of ingredients (N)
        int N = scanner.nextInt();

        // Read the maximum ingredient quantities
        int[] quantity = new int[N];
        for (int i = 0; i < N; i++) {
            quantity[i] = scanner.nextInt();
        }

        // Read the potency of each ingredient
        int[] potency = new int[N];
        for (int i = 0; i < N; i++) {
            potency[i] = scanner.nextInt();
        }

        // Read the required quantities for each potion
        int[][] required = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                required[i][j] = scanner.nextInt();
            }
        }

        // Calculate the maximum combined potency
        int result = maxCombinedPotency(N, quantity, potency, required);
        System.out.println(result);

        scanner.close();
    }
}