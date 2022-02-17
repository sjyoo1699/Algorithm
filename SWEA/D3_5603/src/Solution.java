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
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			int total = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				total += arr[i];
			}
			
			int average = total / N;
			int result = 0;
			for (int i = 0; i < N; i++) {
				if(arr[i] >= average) continue;
				result += average - arr[i];
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.close();
	}
}
