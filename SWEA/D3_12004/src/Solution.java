import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean pos = false;
			for (int i = 1; i <= 9; i++) {
				if(pos) break;
				for (int j = 1; j <= 9; j++) {
					if(i * j == N) {
						pos = true;
						break;
					}
				}
			}
			
			if(pos) System.out.println("#" + tc + " Yes");
			else System.out.println("#" + tc + " No");
		}
	}
}
