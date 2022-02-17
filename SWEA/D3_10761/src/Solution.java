import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int Oposition, Bposition;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] color = new char[N];
			int[] position = new int[N];
			for (int i = 0; i < N; i++) {
				color[i] = st.nextToken().charAt(0);
				position[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			int timeThatPreviousRobotSpend = 0;
			char currentRobot = color[0];
			Oposition = 1;
			Bposition = 1;
			
			for (int i = 0; i < N; i++) {
				if(color[i] == currentRobot) {
					timeThatPreviousRobotSpend += moveAndPressButton(color[i], position[i]);
				}
				else {
					int dist = moveAndPressButton(color[i], position[i]) - 1;
					if(timeThatPreviousRobotSpend == 0) {
						timeThatPreviousRobotSpend += dist + 1;
						currentRobot = color[i];
						continue;
					}
					if(dist > timeThatPreviousRobotSpend) {
						result += dist + 1;
					}
					else {
						result += timeThatPreviousRobotSpend + 1;
					}
					timeThatPreviousRobotSpend = 0;
				}
				currentRobot = color[i];
			}
			
			result += timeThatPreviousRobotSpend;
			
			System.out.println("#" + tc + " " + result);
		}
	}

	private static int moveAndPressButton(char color, int dest) {
		if(color == 'O') {
			int distance = Math.abs(dest - Oposition);
			Oposition = dest;
			return distance + 1;
		}
		else {
			int distance = Math.abs(dest - Bposition);
			Bposition = dest;
			return distance + 1;
		}
	}
}
