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
