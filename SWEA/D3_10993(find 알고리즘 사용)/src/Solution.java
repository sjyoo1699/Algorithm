import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static int[] x, y, s, parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			x = new int[N];
			y = new int[N];
			s = new int[N];
			parent = new int[N];
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
				s[i] = Integer.parseInt(st.nextToken());
				parent[i] = i;
			}
			
			char[] result = new char[N];
			
			for (int i = 0; i < N; i++) {
				List<Integer> list = findCity(i);
				if(list.isEmpty()) result[i] = 'K';
				else if(list.size() >= 2) result[i] = 'D';
				else {
					result[i] = 'P';
					parent[i] = list.get(0);
				}
			}
			
			bw.write("#" + tc);
			for (int i = 0; i < N; i++) {
				if(result[i] == 'P') bw.write(" " + (find(i) + 1));
				else bw.write(" " + result[i]);
			}
			bw.write("\n");
		}
		bw.close();
	}

	private static int find(int i) {
		if(i == parent[i]) return i;
		else {
			int p = find(parent[i]);
			parent[i] = p;
			return p;
		}
	}

	private static List<Integer> findCity(int i) {
		List<Integer> list = new LinkedList<>();
		double maxThr = Double.MIN_VALUE;
		for (int j = 0; j < N; j++) {
			if(j == i) continue;
			double thr = s[j] / (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
			if(thr > s[i]) {
				if(thr == maxThr) list.add(j);
				else if(thr > maxThr) {
					maxThr = thr;
					list = new LinkedList<>();
					list.add(j);
				}
			}
		}
		return list;
	}
}
