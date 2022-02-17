import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] arr = br.readLine().toCharArray();
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == '-') continue;
				
				for (int j = i + 1; j < arr.length; j++) {
					if(arr[i] == arr[j]) {
						arr[i] = '-';
						arr[j] = '-';
						break;
					}
				}
			}
			Arrays.sort(arr);
			String result = new String(arr);
			result = result.replaceAll("-", "");
			System.out.println("#" + tc + " " + (result.length() == 0 ? "Good" : result));
		}
	}
}
