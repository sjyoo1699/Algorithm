## Prgms 크레인 인형뽑기 게임
>> https://programmers.co.kr/learn/courses/30/lessons/64061

************
자료구조 스택을 활용한 문제이다.


맵을 스택으로 변환한 후 바구니도 스택으로 만들어서 해결하면 되는 간단한 문제이다.
************

```java
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer>[] map = new Stack[N];
        for (int i = 0; i < N; i++) {
			map[i] = new Stack<>();
		}
        
        for (int i = N - 1; i >= 0; i--) {
			int[] line = board[i];
			for (int j = 0; j < N; j++) {
				if(line[j] == 0) continue;
				map[j].push(line[j]);
			}
		}
        
        Stack<Integer> basket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
			int num = moves[i] - 1;
			if(map[num].isEmpty()) continue;
			int popped = map[num].pop();
			
			if(!basket.isEmpty() && basket.peek() == popped) {
				basket.pop();
				answer += 2;
			}
			
			else {
				basket.push(popped);
			}
		}
        
        return answer;
    }
}
```
