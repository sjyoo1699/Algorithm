import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int len = people.length;
        int leftPeople = len;
        boolean[] check = new boolean[len];
        
        for (int i = len - 1; i >= 0; i--) {
        	if(check[i]) continue;
        	answer++;
        	leftPeople--;
			int leftWeight = limit - people[i];
			check[i] = true;
			
			boolean isEnd = true;
			Stack<Integer> stack = new Stack<>();
			for (int j = 0; j < i; j++) {
				if(check[j]) continue;
				stack.add(j);
				if(people[j] > leftWeight) {
					isEnd = false;
					stack.pop();
					if(!stack.isEmpty()) {
						check[stack.pop()] = true;
						leftPeople--;
					} 
					break;
				}
			}
			
			if(isEnd) {
				if(leftPeople >= 1) leftPeople--;
				if(leftPeople == 0) break;
				if(leftPeople == 1) answer += 1;
				else if(leftPeople % 2 == 1) answer += leftPeople/2 + 1;
				else answer += leftPeople/2;
				break;
			}
		}
        
        return answer;
    }
}
