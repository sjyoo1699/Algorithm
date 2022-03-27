## Prgms 정수 삼각형
>https://programmers.co.kr/learn/courses/30/lessons/43105

***********
트리 구조를 내려가면서 누적합을 구하는 문제였다.


누적합을 구하기 위한 별도의 배열을 만들어 주고 루트에서부터 내려가면서 누적합을 업데이트 해준 후


가장 아래 단의 노드들에서 최대값을 찾아서 해결하였다.
***********

```java
class Solution {
    public int solution(int[][] triangle) {
        int[][] sum = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
			sum[i] = new int[i + 1];
		}
        
        sum[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
			int len = i + 1;
			for (int j = 0; j < len; j++) {
				int parent1 = j - 1 < 0 ? -1 : sum[i - 1][j - 1];
				int parent2 = j == len - 1 ? -1 : sum[i - 1][j];
				
				sum[i][j] = triangle[i][j] + Math.max(parent1, parent2);
			}
		}
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < triangle.length; i++) {
			answer = Math.max(answer, sum[triangle.length - 1][i]);
		}
        
        return answer;
    }
}
```
