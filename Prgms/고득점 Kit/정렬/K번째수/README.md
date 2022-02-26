## Prgms K번째수
>https://programmers.co.kr/learn/courses/30/lessons/42748

******
배열을 구간별로 잘라서 정렬을 하는 문제였다. 배열을 자르는 데에 Arrays.copyOf와 System.arrayCopy 중 어떤 걸 쓸 지 고민해보고 검색해본 결과 성능은 비슷하다고 한다. copyOf가 arrayCopy로
만든 함수이기 때문이다. arrayCopy는 C의 memcopy처럼 시스템단에서 복사하는 것이기 때문에 그냥 포문을 돌면서 배열을 옮기는 것보다 약 2배정도 빠르다.
******

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
			int startIndex = commands[i][0] - 1;
			int length = commands[i][1];
			int k = commands[i][2] - 1;
			
			int[] newArr = Arrays.copyOfRange(array, startIndex, length);
			Arrays.sort(newArr);
			answer[i] = newArr[k];
		}
        return answer;
    }
}
```
