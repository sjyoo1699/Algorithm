class Solution {
	int[] arr;
	int targetNum, n, result;
    public int solution(int[] numbers, int target) {
        arr = numbers;
        targetNum = target;
        n = numbers.length;
        result = 0;
        dfs(0, 0);
        return result;
    }
	private void dfs(int index, int num) {
		if(index == n) {
			if(num == targetNum) result++;
			return;
		}
		
		dfs(index + 1, num + arr[index]);
		dfs(index + 1, num - arr[index]);
	}
}
