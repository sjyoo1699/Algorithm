import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
			if(map.containsKey(completion[i])) map.replace(completion[i], map.get(completion[i]) + 1);
			else map.put(completion[i], 1);
		}
        
        String answer = "";
        for (int i = 0; i < participant.length; i++) {
			String candi = participant[i];
			
			if(!map.containsKey(candi)) {
				answer = candi;
				break;
			}
			
			if(map.get(candi) == 1) map.remove(candi);
			else map.replace(candi, map.get(candi) - 1);
		}
        
        return answer;
    }
}
