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
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int left = B - E;
			if(left < 0) left = 0;
			int right = B + E;
			int result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int element = Integer.parseInt(st.nextToken());
				int cnt = left / element;
				if(cnt == 0) cnt = 1;
				boolean isPosible = false;
				
				while(cnt * element <= right) {
					if(cnt * element >= left && cnt * element <= right) {
						isPosible = true;
						break;
					}
					cnt++;
				}
				
				if(isPosible) result++;
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.close();
	}
}
