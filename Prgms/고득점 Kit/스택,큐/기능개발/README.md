## Prgms 기능개발
>https://programmers.co.kr/learn/courses/30/lessons/42586

******************
처음에는 작업의 진행도 배열 Progresses를 순서대로 탐색하며 필요한 시간을 구하고 그 시간만큼 작업하였을 때 완료되는 작업들을 반복문을 통해 찾는 방법으로 구현하였다.


하지만 이 문제는 큐와 스택을 활용하는 문제이기 때문에 큐를 활용한 방법으로 다시 풀어보았다.


처음에 풀었을 때는 큐나 스택을 활용할 곳이 없다고 느껴졌었는데, 두 번째 풀 때 시간을 기준으로 반복문을 돌리니까 큐를 활용할 곳이 보였고


이 방법이 훨씬 더 효율적이고 코드도 깔끔했다.

******************

```java
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			q.offer(new int[] { progresses[i], speeds[i] });
		}

		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			if (q.isEmpty())
				break;
			int cnt = 0;
			while (!q.isEmpty() && q.peek()[0] + q.peek()[1] * i >= 100) {
				cnt++;
				q.poll();
			}
			if (cnt != 0)
				list.add(cnt);
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.remove(0);
		}

		return answer;
	}
}
```
