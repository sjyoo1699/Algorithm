## Prgms 단어 변환
>https://programmers.co.kr/learn/courses/30/lessons/43163

***************
이 문제가 dfs 문제라는 것을 알고 봤기 때문에 쉬웠던 것 같다. "이 문제는 dfs다."라는 전제가 없었다면 dfs를 사용해서 풀어야하는지 감을 잡기 어려웠을 것 같다.



이 문제를 dfs라고 파악하는 힌트는 begin 단어에서 target 단어로 가는 방식이 마치 그래프에서 이웃 노드들을 방문하며 도착 지점을 찾는 방식과 같기 때문에 이 부분을 캐치해야 한다.



그리고 이 경로의 길이가 가장 짧은 것을 구하는 문제기 때문에 전형적인 dfs 문제가 된다.
***************

```java
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
```
