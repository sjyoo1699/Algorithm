import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
			arr[i] = citations[i];
		}
        Arrays.sort(arr, Comparator.reverseOrder());
        
        for (int i = 0; i < arr.length; i++) {
			int candi = arr[i];
			if(candi <= i + 1) answer = Math.max(answer, candi);
			
			int hCnt = i + 1;
			boolean check = true;
			for (int j = hCnt - 1; j >= 0; j--) {
				if(arr[j] < hCnt) {
					check = false;
					break;
				}
			}
			if(check) answer = Math.max(answer, hCnt);
		}
        
        return answer;
    }
}