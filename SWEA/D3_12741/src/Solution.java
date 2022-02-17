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
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int shortLeft, shortRight, longLeft, longRight;
			if((B - A) > (D - C)) {
				shortLeft = C;
				shortRight = D;
				longLeft = A;
				longRight = B;
			}
			else {
				shortLeft = A;
				shortRight = B;
				longLeft = C;
				longRight = D;
			}
			
			int size = 0;
			for (int i = shortLeft; i <= shortRight; i++) {
				if(i > longRight) break;
				if(i >= longLeft && i <= longRight) size++;
			}
			
			if(size == 0) System.out.println("#" + tc + " 0");
			else System.out.println("#" + tc + " " + (size - 1));
		}
	}

}
