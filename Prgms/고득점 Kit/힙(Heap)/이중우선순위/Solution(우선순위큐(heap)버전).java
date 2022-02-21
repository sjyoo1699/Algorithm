import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < operations.length; i++) {
			st = new StringTokenizer(operations[i]);
			char command = st.nextToken().charAt(0);
			int val = Integer.parseInt(st.nextToken());
			if(command == 'I') {
				minQ.offer(val);
				maxQ.offer(val);
			}
			else {
				if(val == 1 && !minQ.isEmpty()) {
					minQ.remove(maxQ.poll());
				}
				else if(val == -1 && !minQ.isEmpty()) {
					maxQ.remove(minQ.poll());
				}
			}
		}
        
        if(minQ.isEmpty()) answer = new int[] {0, 0};
        else answer = new int[] {maxQ.poll(), minQ.poll()};
        return answer;
    }
}
