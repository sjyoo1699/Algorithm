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
			long N = Long.parseLong(st.nextToken());
			long Pd = Long.parseLong(st.nextToken());
			long Pg = Long.parseLong(st.nextToken());
			
			boolean pos = false;
			
			if(!((Pg == 100 && Pd != 100) || (Pg == 0 && Pd != 0))) {
				while(N > 0) {
					if((N * Pd / 100.0) - (long)(N * Pd / 100) == 0.0) {
						pos = true;
						break;
					}
					N--;
				}
			}
			
			if(pos) System.out.println("#" + tc + " Possible");
			else System.out.println("#" + tc + " Broken");
		}
	}
}
