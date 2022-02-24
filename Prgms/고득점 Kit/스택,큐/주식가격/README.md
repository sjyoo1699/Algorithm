## Prgms 주식가격
> https://programmers.co.kr/learn/courses/30/lessons/42584

******
효율적인 방법을 찾아서 엄청 고민을 오래한 문제다. 마음에 들 정도로 효율적인 코드를 구상해내지 못해서 결국 나름 효율적인 코드로 제출하였다. 그리고 다른 사람의 풀이를 보는데 스택을 활용한 풀이가 있었다. 가장 첫번째 인덱스부터 탐색을 시작하고 현재 인덱스의 값보다 스택의 peek 값이 작거나 같다면 계속 스택에 넣고, 아니라면 스택에서 pop하여 계산하는 방식이었다. 이 방법이 훨씬 효율적으로 보인다.
******

```java
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
        for (int i = 0; i < prices.length; i++) {
			pq.offer(new int[] {i, prices[i]});
		}
        boolean[] check = new boolean[prices.length];
        while(!pq.isEmpty()) {
        	int[] poll = pq.poll();
        	check[poll[0]] = true;
        	int length = 0;
        	for (int i = poll[0] + 1; i < check.length; i++) {
        		length++;
				if(check[i]) break;
			}
        	answer[poll[0]] = length;
        }
        return answer;
    }
}
```
