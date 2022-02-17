import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	static char[] N;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = br.readLine().toCharArray();
			int max = Integer.parseInt(String.valueOf(N));
			int min = max;
			
			for (int i = 0; i < N.length; i++) {
				for (int j = i + 1; j < N.length; j++) {
					swap(i, j);
					if(N[0] != '0') {
						int M = Integer.parseInt(String.valueOf(N));
						max = Math.max(max, M);
						min = Math.min(min, M);
					}
					swap(i, j);
				}
			}
			
			bw.write("#" + tc + " " + min + " " + max + "\n");
		}
		bw.close();
	}

	private static void swap(int i, int j) {
		char tmp = N[i];
		N[i] = N[j];
		N[j] = tmp;
	}
}
