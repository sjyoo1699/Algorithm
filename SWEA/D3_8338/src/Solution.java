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
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = Integer.parseInt(st.nextToken());
			for (int i = 1; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				result = result + num > result * num ? result + num : result * num;
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.close();
	}
}
