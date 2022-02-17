import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author edonc
 * 처음에는 누적합 구간합 문제인 줄 알았는데, 단순한 포문으로 해결 가능한 문제였다.
 */

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int tmp = 0;
			int result = Integer.MIN_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num < 0 && (tmp > 0)) result = Math.max(result, tmp);
				if(tmp < 0) tmp = 0;
				tmp += num;
				result = Math.max(result, tmp);
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
