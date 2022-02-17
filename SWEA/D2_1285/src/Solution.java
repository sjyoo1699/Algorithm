import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for (int T = 1; T <= tc; T++) {
			int N = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			int minNum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int candidate = Math.abs(Integer.parseInt(st.nextToken()));
				if (min == candidate) minNum++;
				else if(min > candidate) {
					min = candidate;
					minNum = 1;
				}
			}
			
			System.out.println("#" + T + " " + min + " " + minNum);
		}
	}
}
