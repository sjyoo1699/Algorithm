import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(left <= right) {
        	answer++;
        	if(left != right && people[right] + people[left] <= limit) {
        		left++;
        	}
        	right--;
        }
        
        return answer;
    }
}