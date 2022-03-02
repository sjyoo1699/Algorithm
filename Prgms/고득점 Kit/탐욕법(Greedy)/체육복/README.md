## Prgms 체육복
>> https://programmers.co.kr/learn/courses/30/lessons/42862

**********
주어진 배열이 정렬이 안되어 있어서 틀렸던 문제이다. (정렬이 되어 있다는 전제로 짠 알고리즘)


따라서 boolean 배열로 좌표 형식으로 바꾸니 바로 해결되었다. 문제에 주어진 조건만 그대로 구현하는 되는 문제이다.


이 문제가 왜 그리디인지는 잘 모르겠다.
**********


```java
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] reserveArr = new boolean[n + 1];
        boolean[] lostArr = new boolean[n + 1];
        for (int i = 0; i < reserve.length; i++) {
			reserveArr[reserve[i]] = true;
		}
        for (int i = 0; i < lost.length; i++) {
			lostArr[lost[i]] = true;
		}
        
        for (int i = 1; i < n + 1; i++) {
			if(reserveArr[i] && lostArr[i]) {
				answer++;
				reserveArr[i] = false;
				continue;
			}
			
			if(lostArr[i]) { 
				if(reserveArr[i - 1]) {
					reserveArr[i - 1] = false;
					answer++;
				}
				else if(i < n && reserveArr[i + 1] && !lostArr[i + 1]) {
					reserveArr[i + 1] = false;
					answer++;
				}
			}
		}
        return answer;
    }
}
```
