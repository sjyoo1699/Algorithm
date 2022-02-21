## Prgms 이중우선순위
> https://programmers.co.kr/learn/courses/30/lessons/42628

**********
새로운 원소를 삽입하면 오름차순으로 정렬이 되고(Priority) , 최소값과 최대값을 제거할 수 있는(양방향 Queue) 자료구조를 이용한 문제였다.



문제의 분류가 "힙(Heap)"이었기에 문제의 의도는 PriorityQueue를 두 개 사용해서 해결하는 것으로 보인다.


하지만 이 경우 하나의 큐에서 poll 하면 다른 큐에서 remove를 해줘야하기 때문에 비효율적이라 생각하고 직접 우선순위를 가지는 양방향 큐를 구현하였다.


제출 결과 실행 속도는 큐를 두 개 사용한 버전은 70 ~ 130 의 속도가 나왔고, 양방향 큐로 구현한 버전은 평균 속도 40 정도가 나왔다.
**********

> PriorityDeque 를 직접 구현한 버전 (heap이 아닌 링크드리스트 방식으로 구현)
```java
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityDeque pdq = new PriorityDeque();
        StringTokenizer st;
        for (int i = 0; i < operations.length; i++) {
			st = new StringTokenizer(operations[i]);
			char command = st.nextToken().charAt(0);
			int val = Integer.parseInt(st.nextToken());
			if(command == 'I') pdq.offer(val);
			else {
				if(val == 1 && !pdq.isEmpty()) pdq.removeMax();
				else if(val == -1 && !pdq.isEmpty()) pdq.removeMin();
			}
		}
        
        if(pdq.isEmpty()) answer = new int[] {0, 0};
        else answer = new int[] {pdq.tail.value, pdq.head.value};
        return answer;
    }
}


class PriorityDeque {
	Node head;
	Node tail;
	int size;
	
	public PriorityDeque() {
		super();
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void offer(int value) {
		Node currentNode = this.head;
		boolean checkLast = true;
		while(currentNode != null) {
			if(currentNode.value >= value) {
				Node prevNode = currentNode.prev;
				Node newNode = new Node(currentNode, prevNode, value);
				currentNode.prev = newNode;
				if(prevNode == null) this.head = newNode;
				else prevNode.next = newNode;
				checkLast = false;
			}
			currentNode = currentNode.next;
		}
		
		if(checkLast) {
			Node prevNode = this.tail;
			Node newNode = new Node(null, prevNode, value);
			this.tail = newNode;
			if(this.head == null) this.head = newNode;
			if(prevNode != null) prevNode.next = newNode;
		}
		
		this.size++;
	}
	
	public void removeMin() {
		if(this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		this.size--;
	}
	
	public void removeMax() {
		if(this.size == 1) {
			this.tail = null;
			this.head = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		this.size--;
	}
	
	public boolean isEmpty() {
		return this.size == 0 ? true : false;
	}
}

class Node {
	Node next;
	Node prev;
	int value;
	
	public Node(Node next, Node prev, int value) {
		super();
		this.next = next;
		this.prev = prev;
		this.value = value;
	}
}
```

> java의 PriorityQueue(Heap)를 두 개 사용한 버전
```java
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < operations.length; i++) {
			st = new StringTokenizer(operations[i]);
			char command = st.nextToken().charAt(0);
			int val = Integer.parseInt(st.nextToken());
			if(command == 'I') {
				minQ.offer(val);
				maxQ.offer(val);
			}
			else {
				if(val == 1 && !minQ.isEmpty()) {
					minQ.remove(maxQ.poll());
				}
				else if(val == -1 && !minQ.isEmpty()) {
					maxQ.remove(minQ.poll());
				}
			}
		}
        
        if(minQ.isEmpty()) answer = new int[] {0, 0};
        else answer = new int[] {maxQ.poll(), minQ.poll()};
        return answer;
    }
}
```
