## Prgms 베스트앨범
https://programmers.co.kr/learn/courses/30/lessons/42579

******
장르 별로 가장 많이 재생한 노래를 찾기 위해서 HashMap의 key를 장르를 나타내는 String으로, value를 노래들을 나타내는 객체 Songs로 하였다.


Songs와 Song 객체 모두 Comparable을 imlements하였으며, Songs의 프로퍼티로 Song의 PriorityQueue를 만들어서 이 큐에서 2개만 꺼내서 배열을 만들면 정답이 되도록 하였다.


이 문제를 통해 Stream에 대해 공부해야겠다고 생각하였다.
******

```java
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
```
