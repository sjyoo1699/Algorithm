import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] sum = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			sum[0] = Integer.parseInt(st.nextToken());
			int min = sum[0];
			int minIndex = 0;
			for (int i = 1; i < N; i++) {
				sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
				if(min >= sum[i]) {
					min = sum[i];
					minIndex = i;
				}
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < minIndex; i++) {
				max = max < min - sum[i] ? min - sum[i] : max;
			}
			
			for (int i = minIndex + 1; i < N; i++) {
				max = max < sum[i] - min ? sum[i] - min : max;
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
