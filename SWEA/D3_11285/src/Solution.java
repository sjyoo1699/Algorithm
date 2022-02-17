import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] mem = new int[401][401];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 401; i++) {
			for (int j = 0; j < 401; j++) {
				mem[i][j] = -1;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int result = 0;
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(mem[y + 200][x + 200] != -1) {
					result += mem[y + 200][x + 200];
					continue;
				}
				
				double distance = Math.sqrt(x*x + y*y);
				int point = 11;
				for (int j = 20; j <= 200; j+=20) {
					point--;
					if(distance > j) continue;
					mem[y + 200][x + 200] = point;
					result += point;
					break;
				}
				
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.close();
	}
}
