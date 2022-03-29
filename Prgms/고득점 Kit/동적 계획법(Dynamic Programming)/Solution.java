class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] map = new boolean[n][m];
        for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = true;
		}
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] || (i == 0 && j == 0)) continue;
				int up = i - 1 < 0 ? 0 : dp[i - 1][j];
				int left = j - 1 < 0 ? 0 : dp[i][j - 1];
				dp[i][j] = (up + left) % 1000000007;
			}
		}
        return dp[n - 1][m - 1];
    }
}