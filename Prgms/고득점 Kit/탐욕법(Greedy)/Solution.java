class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	boolean check = false;
        	for (int j = i + 1; j <= i + k && j < arr.length; j++) {
				if(arr[j] > arr[i]) {
					check = true;
					k--;
					break;
				}
			}
        	
        	if(!check) sb.append(arr[i]);
		}
        if(k > 0) sb.delete(sb.length() - k, sb.length());
        return sb.toString();
    }
}