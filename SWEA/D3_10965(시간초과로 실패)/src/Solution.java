import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author edonc
 * 소인수분해를 하고 지수가 홀수인 수들을 전부 곱해서 B를 구했음 하지만 시간초과
 */
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int A = Integer.parseInt(br.readLine());
			bw.write("#" + tc + " " + factorization(A) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	
	private static int factorization(int A) {
		int B = 1;
		for (int i = 2; i <= A; i++) {
			if(A % i != 0) continue;
			int cnt = 0;
			while(A % i == 0) {
				A /= i;
				cnt++;
			}
			if(cnt % 2 == 1) B *= i;
		}
		
		return B;
	}
}
