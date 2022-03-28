## Prgms N으로 표현
>https://programmers.co.kr/learn/courses/30/lessons/42895

**********
dp 문제는 어렵다. dp는 한 번 계산한 것은 계산하지 않는다를 기본으로 생각해야 한다. 


그리고 문제의 접근 방식도 중요하다. 이 문제를 처음 접근했을 때 dp 문제라는 것을 몰랐다면 dfs로 완전탐색을 먼저 떠올렸을 것 같다.


사실 완전탐색과 이런 유형의 dp는 크게 다르지 않다. 다만 dp는 한 번 계산한 것은 다시 계산하지 않는다는 것.

**********


```java
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
```
