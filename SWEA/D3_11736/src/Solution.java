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
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int normalCnt = 0;
			for (int i = 1; i < N - 1; i++) {
				if(arr[i] != Math.min(Math.min(arr[i], arr[i - 1]), arr[i + 1]) && arr[i] != Math.max(Math.max(arr[i], arr[i - 1]), arr[i + 1])) normalCnt++;
			}
			
			System.out.println("#" + tc + " " + normalCnt);
		}
	}
}
