import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static int[] dX = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dY = {1, 1, 0, -1, -1, -1, 0, 1};
	static char[][] map;
	static boolean result;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][];
			result = false;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for (int i = 0; (i < N) && !result; i++) {
				for (int j = 0; (j < N) && !result; j++) {
					if(map[i][j] == '.') continue;
					for (int j2 = 0; (j2 < 8) && !result; j2++) {
						if(j + dX[j2] < 0 || j + dX[j2] >= N || i + dY[j2] < 0 || i + dY[j2] >= N) continue;
						check(i + dY[j2], j + dX[j2], j2, 1);
					}
				}
			}
			
			bw.write("#" + tc + " " + (result ? "YES" : "NO") + "\n");
		}
		
		bw.close();
	}

	private static void check(int y, int x, int dir, int cnt) {
		if(map[y][x] == '.') return;
		if(cnt == 4) {
			result = true;
			return;
		}
		
		if(x + dX[dir] < 0 || x + dX[dir] >= N ||y + dY[dir] < 0 || y + dY[dir] >= N) return;
		check(y + dY[dir], x + dX[dir], dir, cnt + 1);
	}
}
