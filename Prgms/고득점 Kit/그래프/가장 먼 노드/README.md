## Prgms 가장 먼 노드
>https://programmers.co.kr/learn/courses/30/lessons/49189

************
초기의 한 지점에서 가장 먼 노드들의 갯수를 구하는 문제이다.


BFS를 이용하였고 BFS의 한 뎁스당 탐색을 진행하여 각각의 뎁스의 갯수를 구하는 방식으로 구현하였다.


따라서 마지막에 잡힌 뎁스의 카운트 값이 정답이 된다.
************


```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
    	int answer = 0;
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int i = 0; i < edge.length; i++) {
			map[edge[i][0]][edge[i][1]] = true;
			map[edge[i][1]][edge[i][0]] = true;
		}
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int cnt = 1;
        while(!q.isEmpty()) {
        	int newCnt = 0;
        	for (int i = 0; i < cnt; i++) {
				int node = q.poll();
				
				for (int j = 1; j <= n; j++) {
					if(!map[node][j] || visit[j]) continue;
					q.offer(j);
					visit[j] = true;
					newCnt++;
				}
			}
        	answer = cnt;
        	cnt = newCnt;
        }
        
        return answer;
    }
}
```
