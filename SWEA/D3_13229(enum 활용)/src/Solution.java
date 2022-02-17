import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc + " " + Day.valueOf(br.readLine()).getLeftDayToNextSunday());
		}
	}
	
	enum Day {
		SUN(7), SAT(1), FRI(2), THU(3), WED(4), TUE(5), MON(6) ;

		final private int leftToNextSunday;
		
		Day(int i) {
			// TODO Auto-generated constructor stub
			this.leftToNextSunday = i;
		}
		
		public int getLeftDayToNextSunday() {
			return this.leftToNextSunday;
		}
	}
}
