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
