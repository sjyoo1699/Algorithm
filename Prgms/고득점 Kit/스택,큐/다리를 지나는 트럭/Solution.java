import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> waitingQ = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
			waitingQ.offer(truck_weights[i]);
		}
        
        int currentBridge_weight = 0;
        Queue<Integer> bridgeQ = new LinkedList<>();
        while(currentBridge_weight != 0 || !waitingQ.isEmpty()) {
        	time++;
        	if(bridgeQ.size() == bridge_length) currentBridge_weight -= bridgeQ.poll();
        	if(!waitingQ.isEmpty() && currentBridge_weight + waitingQ.peek() <= weight) {
        		currentBridge_weight += waitingQ.peek();
        		bridgeQ.offer(waitingQ.poll());
        	}
        	else bridgeQ.offer(0);
        }
        
        return time;
    }
}
