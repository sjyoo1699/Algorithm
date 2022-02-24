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