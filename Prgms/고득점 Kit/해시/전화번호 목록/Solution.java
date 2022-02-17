import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        for (int i = 0; i < phone_book.length; i++) {
			String str = phone_book[i];
			for (int j = 1; j < str.length(); j++) {
				String subStr = str.substring(0, j);
				if(set.contains(subStr)) return false;
			}
		}
        return answer;
    }
}
