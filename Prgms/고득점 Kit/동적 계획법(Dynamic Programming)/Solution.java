import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        if(N == number) return 1;
        HashSet<Integer>[] dp = new HashSet[9];
        for (int i = 1; i < dp.length; i++) {
			dp[i] = new HashSet<Integer>();
			String s = "";
			for (int j = 0; j < i; j++) {
				s += N;
			}
			dp[i].add(Integer.parseInt(s));
		}
        
        for (int i = 2; i < dp.length; i++) {
			makeDp(dp, i);
			if(dp[i].contains(number)) {
				answer = i;
				break;
			}
		}
        return answer;
    }

	private void makeDp(HashSet<Integer>[] dp, int len) {
		int left = 0;
		int right = len;
		
		for (int i = 0; i < len - 1; i++) {
			left += 1;
			right -= 1;
			
			HashSet<Integer> dpLeft = dp[left];
			HashSet<Integer> dpRight = dp[right];
			
			for (Integer integer : dpLeft) {
				for (Integer integer2 : dpRight) {
					if(integer + integer2 != 0)dp[len].add(integer + integer2);
					if(integer - integer2 != 0)dp[len].add(integer - integer2);
					if(integer / integer2 != 0)dp[len].add(integer / integer2);
					dp[len].add(integer * integer2);
				}
			}
		}
	}
}