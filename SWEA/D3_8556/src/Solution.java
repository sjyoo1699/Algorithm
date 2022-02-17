import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] arr = br.readLine().toCharArray();
			
			int cnt = 0;
			double dir = 0;
			for (int i = arr.length - 1; i > 0;) {
				if(arr[i] == 't') {
					if(cnt == 0) {
						dir = 90;
						i -= 4;
					}
					else {
						dir += 90 / Math.pow(2, cnt);
						i -= 4;
					}
					cnt++;
				}
				else {
					if(cnt == 0) {
						dir = 0;
						i -= 5;
					}
					else {
						dir -= 90 / Math.pow(2, cnt);
						i -= 5;
					}
					cnt++;
				}
			}
			
			String result = null;
			
			if(dir == (int)dir) {
				result = "" + (int)dir;
			}
			else {
				int mo = 1;
				while(result == null) {
					mo++;
					if(dir * mo == (int)(dir * mo)) {
						result = (int)(dir*mo) + "/" + mo;
					}
				}
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.close();
	}
}
