class Solution {
    public int solution(int[] money) {
        int[] result = dp(money, 0, money.length - 1);
        int answer = Integer.MIN_VALUE;
        answer = Math.max(result[0], Math.max(result[1], result[3]));
        return answer;
    }

	private int[] dp(int[] money, int left, int right) {
		int length = right - left + 1;
		if(length <= 3) {
			int[] result = new int[4];
			result[0] = money[left];
			result[1] = money[right];
			result[2] = length == 2 ? 0 : money[left] + money[right];
			result[3] = length == 2 ? 0 : money[left + 1];
			return result;
		}
		
		int pivot = (left + right) / 2;
		int[] leftArr = dp(money, left, pivot);
		int[] rightArr = dp(money, pivot + 1, right);
		int[] result = new int[4];
		result[0] = Math.max(leftArr[2] + rightArr[3], Math.max(leftArr[0] + rightArr[0], leftArr[0] + rightArr[3]));
		result[1] = Math.max(leftArr[3] + rightArr[2], Math.max(leftArr[3] + rightArr[1], leftArr[1] + rightArr[1]));
		result[2] = Math.max(leftArr[2] + rightArr[1], Math.max(leftArr[0] + rightArr[2], leftArr[0] + rightArr[1]));
		result[3] = Math.max(leftArr[1] + rightArr[3], Math.max(leftArr[3] + rightArr[0], leftArr[3] + rightArr[3]));
		return result;
	}

}
