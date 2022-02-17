import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	static int[] dX = {0, 1, -1};
	static int[] dY = {-1, 0, 0};
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(br.ready()) {
			int tc = Integer.parseInt(br.readLine());
			map = new char[100][];
			for (int i = 0; i < 100; i++) {
				map[i] = br.readLine().replace(" ", "").toCharArray();
			}
			
			int startX = -1;
			for (int i = 0; i < 100; i++) {
				if(map[99][i] == '2') {
					startX = i;
					break;
				}
			}
			
			bw.write("#" + tc + " " + find(startX) + "\n");
		}
		bw.close();
	}

	private static int find(int startX) {
		int y = 99;
		int x = startX;
		
		while(y != 0) {
			for (int i = 2; i >= 0; i--) {
				int newX = x + dX[i];
				int newY = y + dY[i];
				
				if(newX >= 0 && newX < 100 && newY >= 0 && newY < 100 && map[newY][newX] == '1') {
					if(i == 0) {
						x = newX;
						y = newY;
						break;
					}
					else {
						while(newX >= 0 && newX < 100 && map[newY][newX] == '1') {
							newX += dX[i];
						}
						if(i == 2) newX += dX[1];
						else newX += dX[2];
						newY--;
						x = newX;
						y = newY;
						break;
					}
				}
			}
		}
		
		return x;
	}
}
