## Prgms 도둑질
> https://programmers.co.kr/learn/courses/30/lessons/42897

********** 
DP 문제이지만 Divide and Conquer 방식으로 해결하였다. ``` DP의 점화식 방식이 바로 떠오르지 않았다. 작은 문제의 해가 합쳐져 큰 해가 되는 것인데 사실 divide and conquer 방식으로 풀었다면 DP로도 풀 수 있다는 말이다.```


계속 쪼개다가 길이가 3개 이하인 블럭까지 쪼개지면 해당 블럭에서



왼쪽 끝만 턴 경우, 오른쪽 끝만 턴 경우, 양쪽 끝을 다 턴 경우, 양쪽 다 털지 않은 경우로 나누어서 저장한다.



이 블럭들을 각각의 경우에 맞게 합쳐준다.



``` DP 방식으로 다시 고민해보고 풀어볼 필요가 있다. ```

**********

```java
class Solution {
    public int solution(int[] money) {
        int[] result = dp(money, 0, money.length - 1);
        int answer = Integer.MIN_VALUE;
        answer = Math.max(result[0], Math.max(result[1], result[3]));
        return answer;
    }

	private int[] dp(int[] money, int left, int right) {
		int length = right - left + 1;
		if(length <= 3) {
			int[] result = new int[4];
			result[0] = money[left];
			result[1] = money[right];
			result[2] = length == 2 ? 0 : money[left] + money[right];
			result[3] = length == 2 ? 0 : money[left + 1];
			return result;
		}
		
		int pivot = (left + right) / 2;
		int[] leftArr = dp(money, left, pivot);
		int[] rightArr = dp(money, pivot + 1, right);
		int[] result = new int[4];
		result[0] = Math.max(leftArr[2] + rightArr[3], Math.max(leftArr[0] + rightArr[0], leftArr[0] + rightArr[3]));
		result[1] = Math.max(leftArr[3] + rightArr[2], Math.max(leftArr[3] + rightArr[1], leftArr[1] + rightArr[1]));
		result[2] = Math.max(leftArr[2] + rightArr[1], Math.max(leftArr[0] + rightArr[2], leftArr[0] + rightArr[1]));
		result[3] = Math.max(leftArr[1] + rightArr[3], Math.max(leftArr[3] + rightArr[0], leftArr[3] + rightArr[3]));
		return result;
	}

}
```
