//implement skip steps problem using dynamic programming
public class TwoStep {
    public static void main(String[] args) {
        int n = 5; // Number of steps
        System.out.println("Number of ways to reach the top: " + countWays(n));
    }

    public static int countWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to stay at the ground
        dp[1] = 1; // Base case: 1 way to reach the first step

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Sum of ways to reach the previous two steps
        }
        return dp[n];
    }
}