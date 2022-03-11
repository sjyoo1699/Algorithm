## Prgms 섬 연결하기
>https://programmers.co.kr/learn/courses/30/lessons/42861

************
주어진 모든 섬을 연결하는 최소의 비용을 구하는 문제이다.


PriorityQueue를 사용(비용이 가장 적은 순)하여 하나 씩 섬을 뽑고 방문으로 체크, 비용 계산을 한 후 해당 섬에 연결되어 있고 아직 방문하지 않은 섬들을 다시 큐에 넣는다.


위 과정을 반복하면 해결.



```다른 사람들의 풀이를 보니 유니온 파인드 알고리즘을 사용해서 많이 풀었다. ```
************

```java
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] map = new int[n][n];
        for (int i = 0; i < costs.length; i++) {
			int island1 = costs[i][0];
			int island2 = costs[i][1];
			int cost = costs[i][2];
			
			map[island1][island2] = cost;
			map[island2][island1] = cost;
		}
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
        
        boolean[] check = new boolean[n];
        int cnt = 0;
        pq.offer(new int[] {0, 0, 0});
        while(!pq.isEmpty()) {
        	int[] island = pq.poll();
        	if(check[island[1]]) continue;
        	
        	check[island[1]] = true;
        	answer += island[2];
        	if(++cnt == n) break;
        	
        	for (int i = 0; i < n; i++) {
				if(map[island[1]][i] == 0 || check[i]) continue;
				pq.offer(new int[] {island[1], i, map[island[1]][i]});
			}
        }
        
        return answer;
    }
}
```
