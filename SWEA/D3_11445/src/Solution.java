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
			char[] P = br.readLine().toCharArray();
			char[] Q = br.readLine().toCharArray();
			
			boolean result = false;
			
			if(P.length + 1 == Q.length) result = QlengthIsLongCase(P, Q);
			
			System.out.println("#" + tc + " " + (result ? "N" : "Y"));
		}
	}

	private static boolean QlengthIsLongCase(char[] p, char[] q) {
		for (int i = 0; i < p.length; i++) {
			if(p[i] != q[i]) return false;
		}
		if(q[q.length - 1] == 'a') return true;
		return false;
	}
}
