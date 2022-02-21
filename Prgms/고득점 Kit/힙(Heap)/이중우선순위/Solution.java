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
