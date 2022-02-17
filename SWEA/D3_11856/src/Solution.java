import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] S = br.readLine().toCharArray();
			int[] check = new int[26];
			
			for (int i = 0; i < 4; i++) {
				check[S[i] - 65]++;
			}
			
			int twoCnt = 0;
			for (int i = 0; i < 25; i++) {
				if(check[i] == 2) twoCnt++;
			}
			
			if(twoCnt == 2) System.out.println("#" + tc + " Yes");
			else System.out.println("#" + tc + " No");
		}
	}
}
