import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int classDayInOneWeek = 0;
			int[] arr = new int[7];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					arr[i] = 1;
					classDayInOneWeek++;
				}
			}
			
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < 7; i++) {
				if(arr[i] == 0) continue;
				int pointer = i;
				int cnt = 0;
				int size = 0;
				
				while(cnt < n) {
					pointer = pointer % 7;
					size++;
					if(arr[pointer] == 1) cnt++;
					if(pointer == 6) {
						int leftCnt = n - cnt;
						if(leftCnt > classDayInOneWeek) {
							if(leftCnt % classDayInOneWeek == 0) {
								size += ((leftCnt / classDayInOneWeek) - 1) * 7;
								cnt = n - classDayInOneWeek;
							}
							else {
								size += (leftCnt / classDayInOneWeek) * 7;
								cnt = n - (leftCnt % classDayInOneWeek);
							}
						}
					}
					pointer++;
				}
				
				result = Math.min(result, size);
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
