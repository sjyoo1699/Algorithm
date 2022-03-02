class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] reserveArr = new boolean[n + 1];
        boolean[] lostArr = new boolean[n + 1];
        for (int i = 0; i < reserve.length; i++) {
			reserveArr[reserve[i]] = true;
		}
        for (int i = 0; i < lost.length; i++) {
			lostArr[lost[i]] = true;
		}
        
        for (int i = 1; i < n + 1; i++) {
			if(reserveArr[i] && lostArr[i]) {
				answer++;
				reserveArr[i] = false;
				continue;
			}
			
			if(lostArr[i]) { 
				if(reserveArr[i - 1]) {
					reserveArr[i - 1] = false;
					answer++;
				}
				else if(i < n && reserveArr[i + 1] && !lostArr[i + 1]) {
					reserveArr[i + 1] = false;
					answer++;
				}
			}
		}
        return answer;
    }
}