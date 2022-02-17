import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int result = 0;
			for (int i = A; i <= B; i++) {
				double tmp = Math.sqrt(i);
				if(tmp != (int)tmp) continue;
				if(!isPalindrome((int)tmp)) continue;
				if(isPalindrome(i)) result++;
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.close();
	}

	private static boolean isPalindrome(int digit) {
		char[] arr = ("" + digit).toCharArray();
		int len = arr.length;
		for (int i = 0; i < len/2; i++) {
			if(arr[i] != arr[len - 1 - i]) return false;
		}
		return true;
	}
}
