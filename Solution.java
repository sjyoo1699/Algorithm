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