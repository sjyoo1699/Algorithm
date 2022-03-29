## Prgms 등굣길
>https://programmers.co.kr/learn/courses/30/lessons/42898

**********
경로의 개수를 구하는 문제이다. memoization을 이용하여 한번 완전탐색을 하여 이전 경로들을 더해주며 탐색하면


목적지까지의 경로의 개수를 구할 수 있다.
**********


```java
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
```
