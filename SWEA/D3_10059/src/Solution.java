import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			int first = Integer.parseInt(s.substring(0, 2));
			int second = Integer.parseInt(s.substring(2));
			
			String result = null;
			if(first <= 12 && second <= 12 && first != 0 && second != 0) result = "AMBIGUOUS";
			else if((first <= 12 && first != 0) && (second > 12 || second == 0)) result = "MMYY";
			else if((second <= 12 && second != 0) && (first > 12 || first == 0)) result = "YYMM";
			else result = "NA";
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.close();
	}
}
