import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    	Queue<int[]> q = new LinkedList<>();
    	for (int i = 0; i < progresses.length; i++) {
			q.offer(new int[] {progresses[i], speeds[i]});
		}
    	
    	List<Integer> list = new LinkedList<>();
    	for (int i = 0; i < 100; i++) {
    		if(q.isEmpty()) break;
    		int cnt = 0;
			while(!q.isEmpty() && q.peek()[0] + q.peek()[1] * i >= 100) {
				cnt++;
				q.poll();
			}
			if(cnt != 0) list.add(cnt);
		}
    	
    	int[] answer = new int[list.size()];
    	for (int i = 0; i < answer.length; i++) {
			answer[i] = list.remove(0);
		}
    	
        return answer;
    }
}