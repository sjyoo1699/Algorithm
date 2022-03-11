import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        List<int[]> sorted = new ArrayList<>(routes.length);
        for (int i = 0; i < routes.length; i++) {
        	sorted.add(routes[i]);
		}
        
        Collections.sort(sorted, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
        
        List<Integer> cameras = new ArrayList<>();
        for (int[] car : sorted) {
			boolean isPassCamera = false;
			int start = car[0];
			int end = car[1];
			for (Integer integer : cameras) {
				if(end < integer) break;
				if(start <= integer && end >= integer) {
					isPassCamera = true;
					break;
				}
			}
			if(!isPassCamera) cameras.add(end);
		}
        
        return cameras.size();
    }
}