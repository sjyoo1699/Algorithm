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