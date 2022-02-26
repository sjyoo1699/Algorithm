import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        Integer[] result = new Integer[numbers.length];
        for (int i = 0; i < result.length; i++) {
			result[i] = numbers[i];
		}
        Arrays.sort(result, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String o1S = o1.toString();
				String o2S = o2.toString();
				return Integer.parseInt(o2S + o1S) - Integer.parseInt(o1S + o2S);
			}
		});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
			sb.append(result[i]);
		}
        String answer = sb.toString();
        String findZero = answer.replaceAll("0", "");
        if(findZero.equals("")) answer = "0";
        return answer;
    }
}
