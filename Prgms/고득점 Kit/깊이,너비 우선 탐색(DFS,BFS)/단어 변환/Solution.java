class Solution {
	int answer;
    public int solution(String begin, String target, String[] words) {
    	answer = Integer.MAX_VALUE;
    	boolean[] check = new boolean[words.length];
        dfs(begin, target, words, check, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
	private void dfs(String currentWord, String target, String[] words, boolean[] check, int cnt) {
		if(currentWord.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if(!check[i] && isNearNode(currentWord, words[i])) {
				check[i] = true;
				dfs(words[i], target, words, check, cnt + 1);
				check[i] = false;
			}
		}
	}
	
	private boolean isNearNode(String firstNode, String secondNode) {
		int result = 0;
		for (int i = 0; i < firstNode.length(); i++) {
			if(firstNode.charAt(i) != secondNode.charAt(i)) result++;
		}
		return result == 1;
	}
}
