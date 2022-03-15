## Prgms 네트워크
>https://programmers.co.kr/learn/courses/30/lessons/43162

****************
그래프에서 연결된 노드들의 뭉치의 개수를 찾는 문제였다.


반복문을 통해 모든 노드들을 순회하며 방문하지 않은 노드는 dfs를 돌면서 방문하는 모든 노드를 방문체크를 하면 되는 문제이다.
****************

```java
class Solution {
    public int solution(int n, int[][] computers) {
    	int answer = 0;
    	boolean[] check = new boolean[n];
        
        for (int i = 0; i < n; i++) {
			if(check[i]) continue;
			answer++;
			dfs(computers, check, i);
		}
        
        return answer;
    }
	private void dfs(int[][] computers, boolean[] check, int i) {
		check[i] = true;
		
		for (int j = 0; j < computers.length; j++) {
			if(computers[i][j] == 1 && !check[j]) dfs(computers, check, j);
		}
	}
}
```
