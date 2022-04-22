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