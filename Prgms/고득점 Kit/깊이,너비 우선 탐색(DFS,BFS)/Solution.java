import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

class Solution {
	int n;
	boolean isEnd;
	
    public String[] solution(String[][] tickets) {
    	n = tickets.length + 1;
        String[] answer = new String[n];
        HashMap<String, List<Ticket>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
			if(map.containsKey(tickets[i][0])) map.get(tickets[i][0]).add(new Ticket(i, tickets[i][1], false));
			else {
				List<Ticket> list = new LinkedList<>();
				list.add(new Ticket(i, tickets[i][1], false));
				map.put(tickets[i][0], list);
			}
		}
        
        for (Entry<String, List<Solution.Ticket>> entry : map.entrySet()) {
			List<Ticket> val = entry.getValue();
			Collections.sort(val);
		}
        
        isEnd = false;
        dfs(map, answer, "ICN", 0);
        
        return answer;
    }

	private void dfs(HashMap<String, List<Ticket>> map, String[] answer, String string, int cnt) {
		if(isEnd) return;
		answer[cnt] = string;
		
		if(cnt == n - 1) {
			isEnd = true;
			return;
		}
		
		if(!map.containsKey(string)) return;
		
		List<Ticket> list = map.get(string);
		for (Ticket ticket : list) {
			if(isEnd) return;
			if(ticket.isUsed) continue;
			ticket.isUsed = true;
			dfs(map, answer, ticket.destination, cnt + 1);
			ticket.isUsed = false;
		}
	}
	
	class Ticket implements Comparable<Ticket> {
		int index;
		String destination;
		boolean isUsed;
		
		@Override
		public int compareTo(Solution.Ticket o) {
			return this.destination.compareTo(o.destination);
		}

		public Ticket(int index, String destination, boolean isUsed) {
			super();
			this.index = index;
			this.destination = destination;
			this.isUsed = isUsed;
		}
	}
}