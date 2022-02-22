## Prgms 프린터
> https://programmers.co.kr/learn/courses/30/lessons/42587

************
문제에 주어진 조건 그대로를 구현하였다. 프린터의 대기열로 Queue를 사용하였고, 가장 중요도가 높은 인쇄물의 정보를 계속 업데이트를 해야했기에


PriorityQueue도 같이 사용해주었다. 인쇄가 된 게시물을 PriorityQueue에서 remove를 해줘야 해서 비효율적인 면이 있다. 


************


```java
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}
		});
        
        for (int i = 0; i < priorities.length; i++) {
        	int[] el = new int[] {i, priorities[i]};
        	q.offer(el);
        	pq.offer(el);
		}
        
        int printCnt = 0;
        while(!q.isEmpty()) { 
        	int[] el = q.poll();
        	if(pq.peek()[1] > el[1]) q.offer(el);
        	else {
        		pq.remove(el);
        		printCnt++;
        		if(el[0] == location) break;
        	}
        }
        return printCnt;
    }
}
```
