## Prgms H-Index
> https://programmers.co.kr/learn/courses/30/lessons/42747

*************
H-index를 찾기 위해선 동시에 두 가지 방법의 탐색이 필요했다. 일단 내림차순으로 정렬을 해놓고 탐색을 시작하는데 첫 번째 방법은 원소의 값이 현재 인덱스 + 1 보다 작거나 같은가



두 번째 방법은 현재 인덱스 + 1 값을 H 의 후보로 정하고 이전 인덱스의 값들이 이 H 값보다 크거나 같은가



이렇게 동시에 두 가지 방법을 사용하여 문제를 해결하였다.
*************

```java
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
			arr[i] = citations[i];
		}
        Arrays.sort(arr, Comparator.reverseOrder());
        
        for (int i = 0; i < arr.length; i++) {
			int candi = arr[i];
			if(candi <= i + 1) answer = Math.max(answer, candi);
			
			int hCnt = i + 1;
			boolean check = true;
			for (int j = hCnt - 1; j >= 0; j--) {
				if(arr[j] < hCnt) {
					check = false;
					break;
				}
			}
			if(check) answer = Math.max(answer, hCnt);
		}
        
        return answer;
    }
}
```
