import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] commandColor = new char[N];
			int[] commandPosition = new int[N];
			for (int i = 0; i < N; i++) {
				commandColor[i] = st.nextToken().charAt(0);
				commandPosition[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			int[] position = new int[2];
			position[0] = 1;
			position[1] = 1;
			
			for (int i = 0; i < N; i++) {
				int curRobot = Robot.valueOf("" + commandColor[i]).ordinal();
				int otherRobot = curRobot == 1 ? 0 : 1;
				int t = Math.abs(commandPosition[i] - position[curRobot]) + 1;
				position[curRobot] = commandPosition[i];
				
				for (int j = i + 1; j < N; j++) {
					if(commandColor[j] != commandColor[i]) {
						int dist = Math.abs(position[otherRobot] - commandPosition[j]);
						if(dist <= t) position[otherRobot] = commandPosition[j];
						else {
							if(position[otherRobot] < commandPosition[j]) position[otherRobot] += t;
							else position[otherRobot] -= t;
						}
						break;
					}
				}
				result += t;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	enum Robot {
		B, O;
	}
}
