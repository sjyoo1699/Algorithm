## Prgms 타겟 넘버
>https://programmers.co.kr/learn/courses/30/parts/12421

**********
가장 쉬운 난이도의 dfs 문제였다.



주어진 뎁스가 깊지 않기 때문에 dfs를 쓰기 충분한 크기였고 따로 백 트래킹을 하지 않아도 되었다. 
**********


```java
class Solution {
	int[] arr;
	int targetNum, n, result;
	
    public int solution(int[] numbers, int target) {
        arr = numbers;
        targetNum = target;
        n = numbers.length;
        result = 0;
        dfs(0, 0);
        return result;
    }
    
	private void dfs(int index, int num) {
		if(index == n) {
			if(num == targetNum) result++;
			return;
		}
		
		dfs(index + 1, num + arr[index]);
		dfs(index + 1, num - arr[index]);
	}
}
```
