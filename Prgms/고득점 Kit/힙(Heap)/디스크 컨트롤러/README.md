## Prgms 디스크 컨트롤러
> https://programmers.co.kr/learn/courses/30/lessons/42627

************
디스크의 스케쥴링을 구현하는 문제 PriorityQueue를 두 개 사용하면 어렵지 않게 구현할 수 있었다. 대기하고 있는 작업들 중 소요 시간이 가장 짧은 것 부터 처리해주면 된다.
```소요 시간이 짧은 것부터 우선적으로 처리해야 그 다음 태스크들에 더해지는 소요시간이 짧기 때문```
************

```java
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> nextJobQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
        PriorityQueue<int[]> waitingQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
        
        for (int i = 0; i < jobs.length; i++) {
			nextJobQ.offer(jobs[i]);
		}
        
        int currentTime = 0;
        int totalJobTime = 0;
        while(!nextJobQ.isEmpty() || !waitingQ.isEmpty()) {
        	if(waitingQ.isEmpty()) {
        		int[] currentJob = nextJobQ.poll();
        		currentTime = currentJob[0] + currentJob[1];
        		totalJobTime += currentJob[1];
        	} else {
        		int[] currentJob = waitingQ.poll();
        		currentTime += currentJob[1];
        		totalJobTime += currentTime - currentJob[0];
        	}
        	
        	while(!nextJobQ.isEmpty() && nextJobQ.peek()[0] <= currentTime) waitingQ.offer(nextJobQ.poll());
        }
        
        return totalJobTime / jobs.length;
    }
}
```
