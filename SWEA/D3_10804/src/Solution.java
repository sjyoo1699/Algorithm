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
			char[] arr = br.readLine().toCharArray();
			char[] resultArr = new char[arr.length];
			for (int i = 0; i < arr.length; i++) {
				char changedChar;
				switch (arr[i]) {
					case 'b': 
						changedChar = 'd';
						break;
					case 'd': 
						changedChar = 'b';
						break;
					case 'q': 
						changedChar = 'p';
						break;
					case 'p': 
						changedChar = 'q';
						break;
					default: 
						changedChar = '-';
				}
				resultArr[arr.length - 1 - i] = changedChar;
			}
			
			System.out.println("#" + tc + " " + new String(resultArr));
		}
	}
}
