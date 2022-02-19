## Prgms 소수 찾기
>https://programmers.co.kr/learn/courses/30/lessons/42839

*******
가능한 모든 수의 조합을 찾고 소수인지 판별하는 문제였다.


가능한 모든 수의 조합을 찾는 데에 순열 알고리즘을 사용하였고, 011과 11이 같은 경우로 취급되기 때문에 Set을 이용하여 이와 같은 중복을 제거해주었다.


그리고 이렇게 찾은 수들에 대해 각각 소수인지 판별해주었다.
*******


```java
import java.util.HashSet;
import java.util.Set;

class Solution {
	int prime;
	Set<Integer> set;
	
    public int solution(String numbers) {
        char[] numArr = numbers.toCharArray();
        boolean[] check = new boolean[numArr.length];
        prime = 0;
        set = new HashSet<>();
        for (int i = 1; i <= numArr.length; i++) {
			permu(numArr.length, i, 0, numArr, check, "");
		}
        return prime;
    }
    
    private void permu(int n, int r, int cnt, char[] arr, boolean[] check, String res) {
    	if(cnt == r) {
    		int intResult = Integer.parseInt(res);
    		if(!set.contains(intResult) && checkPrime(intResult)) prime++;
    		set.add(intResult);
    		return;
    	}
    	
    	for (int i = 0; i < arr.length; i++) {
			if(check[i]) continue;
			check[i] = true;
			permu(n, r, cnt + 1, arr, check, res + arr[i]);
			check[i] = false;
		}
    }

	private boolean checkPrime(int intResult) {
		if(intResult == 2) return true;
		if(intResult == 1 || intResult == 0 || intResult % 2 == 0) return false;
		int rootNum = (int) Math.sqrt(intResult);
		for (int i = 3; i <= rootNum; i+=2) {
			if(intResult % i == 0) return false;
		}
		return true;
	}
}
```
