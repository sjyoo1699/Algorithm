## Prgms 더 맵게
> https://programmers.co.kr/learn/courses/30/lessons/42626

*******
java에 이미 구현되어 있는 PriorityQueue를  사용하면 쉬운 문제였다. 다만 int의 범위를 넘어가는 case가 있을 수 있어서 타입을 신경 써주어야 했고



Queue에서 원소 두 개씩 뽑아서 합치고 넣는 과정을 반복하는데, 종료 조건을 ```Queue가 비었을 때``` 로 하는 바람에 런타임 에러가 발생하였었다.
*******


```java
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
			q.offer(Long.valueOf(scoville[i]));
		}
        
        while(q.size() >= 2 && q.peek() < K) {
        	long first = q.poll();
        	long second = q.poll();
        	long newFood = first + (second * 2L);
        	answer++;
        	q.offer(newFood);
        }
        
        if(q.size() == 1 && q.poll() < K) answer = -1;
        
        return answer;
    }
}
```
