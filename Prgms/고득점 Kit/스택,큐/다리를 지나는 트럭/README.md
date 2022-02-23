## Prgms 다리를 지나는 트럭
>https://programmers.co.kr/learn/courses/30/lessons/42583

**********
한 줄로 다리를 지나가는 트럭의 모습을 컨베이어 벨트를 떠올려서 구현하였다. 컨베이어 벨트를 Queue로 만들어서 무게를 확인해서 더 올라갈 수 있으면 실제 트럭을 큐에 넣고, 더 올라갈 수 없다면


```무게가 0인 트럭(길이 채우기 용 더미)``` 을 넣었다. 이렇게 해서 poll과 offer를 반복하다 보면 대기 큐가 비게 되고, 다리에 올라가 있는 트럭의 무게도 0이 되는 순간 종료한다.
**********

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> waitingQ = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
			waitingQ.offer(truck_weights[i]);
		}
        
        int currentBridge_weight = 0;
        Queue<Integer> bridgeQ = new LinkedList<>();
        while(currentBridge_weight != 0 || !waitingQ.isEmpty()) {
        	time++;
        	if(bridgeQ.size() == bridge_length) currentBridge_weight -= bridgeQ.poll();
        	if(!waitingQ.isEmpty() && currentBridge_weight + waitingQ.peek() <= weight) {
        		currentBridge_weight += waitingQ.peek();
        		bridgeQ.offer(waitingQ.poll());
        	}
        	else bridgeQ.offer(0);
        }
        
        return time;
    }
}
```
