import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int a = 1;
			int b = 1;
			char[] arr = br.readLine().toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 'L') b += a;
				else a += b;
			}
			
			System.out.println("#" + tc + " " + a + " " + b);
		}
	}
}
