## Prgms 모의고사
> https://programmers.co.kr/learn/courses/30/lessons/42840
**********
여러 조건에 따라 완전탐색을 하는 문제였는데, 결과 값으로 리턴해야할 배열의 최대 크기가 3 밖에 되지 않았는데도 불구하고 stream을 사용해서 배열을 만든 것이 시간적으로 많은 비효율적인 요소인 것 같다.

```java
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	
    public int[] solution(int[] answers) {
        PriorityQueue<Supoja> q = new PriorityQueue<>();
        q.add(new Supoja(1, firstCalc(answers)));
        q.add(new Supoja(2, secondCalc(answers)));
        q.add(new Supoja(3, thirdCalc(answers)));
        
        List<Integer> list = new LinkedList<>();
        int max = q.peek().grade;
        list.add(q.poll().num);
        
        while(!q.isEmpty() && q.peek().grade == max) list.add(q.poll().num);
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    private int thirdCalc(int[] answers) {
    	int[] arr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	int result = 0;
    	for (int i = 0; i < answers.length; i++) {
    		if(arr[i % 10] == answers[i]) result++;
    	}
    	return result;
	}

	private int secondCalc(int[] answers) {
		int[] arr = {2, 1, 2, 3, 2, 4, 2, 5};
		int result = 0;
		for (int i = 0; i < answers.length; i++) {
			if(arr[i % 8] == answers[i]) result++;
		}
		return result;
	}

	private int firstCalc(int[] answers) {
		int[] arr = {1, 2, 3, 4, 5};
		int result = 0;
		for (int i = 0; i < answers.length; i++) {
			if(arr[i % 5] == answers[i]) result++;
		}
		return result;
	}

	private class Supoja implements Comparable<Supoja>{
    	int num;
    	int grade;
    	
		public Supoja(int num, int grade) {
			super();
			this.num = num;
			this.grade = grade;
		}

		@Override
		public int compareTo(Solution.Supoja o) {
			// TODO Auto-generated method stub
			return o.grade - this.grade;
		}
    }
}
```
