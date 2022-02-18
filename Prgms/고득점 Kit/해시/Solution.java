import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Songs> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
			if(!map.containsKey(genres[i])) map.put(genres[i], new Songs(new PriorityQueue<Song>()));
			map.get(genres[i]).q.add(new Song(i, plays[i]));
			map.get(genres[i]).addTotalPlays(plays[i]);
		}
        
        List<Integer> list = new LinkedList<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(t -> {
        	PriorityQueue<Song> q = t.getValue().q;
        	for (int i = 0; i < 2; i++) {
				if(q.isEmpty()) break;
				list.add(q.poll().num);
			}
        });
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    private class Songs implements Comparable<Songs>{
    	int totalPlays = 0;
    	PriorityQueue<Song> q;
    	
		public Songs(PriorityQueue<Solution.Song> q) {
			super();
			this.q = q;
		}

		public void addTotalPlays(int totalPlays) {
			this.totalPlays += totalPlays;
		}

		@Override
		public int compareTo(Solution.Songs o) {
			return o.totalPlays - this.totalPlays;
		}
    }
    
    private class Song implements Comparable<Song>{
    	int num;
    	int plays;
    	
		public Song(int num, int plays) {
			super();
			this.num = num;
			this.plays = plays;
		}

		@Override
		public int compareTo(Solution.Song o) {
			// TODO Auto-generated method stub
			if(o.plays == this.plays) return this.num - o.num;
			return o.plays - this.plays;
		}
    }
}
