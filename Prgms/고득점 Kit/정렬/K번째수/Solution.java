import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
			int startIndex = commands[i][0] - 1;
			int length = commands[i][1];
			int k = commands[i][2] - 1;
			
			int[] newArr = Arrays.copyOfRange(array, startIndex, length);
			Arrays.sort(newArr);
			answer[i] = newArr[k];
		}
        return answer;
    }
}
