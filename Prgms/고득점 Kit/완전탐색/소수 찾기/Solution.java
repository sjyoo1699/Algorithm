import java.util.HashSet;
import java.util.Set;

class Solution {
	int prime;
	Set<Integer> set;
	
    public int solution(String numbers) {
        char[] numArr = numbers.toCharArray();
        boolean[] check = new boolean[numArr.length];
        prime = 0;
        set = new HashSet<>();
        for (int i = 1; i <= numArr.length; i++) {
			permu(numArr.length, i, 0, numArr, check, "");
		}
        return prime;
    }
    
    private void permu(int n, int r, int cnt, char[] arr, boolean[] check, String res) {
    	if(cnt == r) {
    		int intResult = Integer.parseInt(res);
    		if(!set.contains(intResult) && checkPrime(intResult)) prime++;
    		set.add(intResult);
    		return;
    	}
    	
    	for (int i = 0; i < arr.length; i++) {
			if(check[i]) continue;
			check[i] = true;
			permu(n, r, cnt + 1, arr, check, res + arr[i]);
			check[i] = false;
		}
    }

	private boolean checkPrime(int intResult) {
		if(intResult == 2) return true;
		if(intResult == 1 || intResult == 0 || intResult % 2 == 0) return false;
		int rootNum = (int) Math.sqrt(intResult);
		for (int i = 3; i <= rootNum; i+=2) {
			if(intResult % i == 0) return false;
		}
		return true;
	}
}
