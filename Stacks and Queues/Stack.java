import java.util.Random;

class Node {

	Node next;
	int data;

	public Node(int d) {
		this.data = d;
	}
	
	public String toString() {
		return this.data+"";
	}

}

public class Stack {
	Node head;

	public Stack() {
		head = null;
	}

	/* Puts the element on top of the stack */
	public void push(int d) {
		if (head == null)
			this.head = new Node(d);
		else {
			Node n = new Node(d);
			n.next = this.head;
			head = n;
		}
	}

	/* Removes the top element of the if not empty */
	public int pop() {
		Node res = null;
		if (head != null) {
			res = head;
			head = head.next;
			return res.data;
		}
		return -1;
	}

	/* Peek at the top element of the stack */
	public int peek() {
		return isEmpty() ? -1 : this.head.data;
	}

	/* Checks if the stack is empty */
	public boolean isEmpty() {
		if (this.head != null)
			return false;
		else 
			return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		Node n = this.head;
		if (n != null) {
			while(n != null) {
				sb.append(n + " -> ");
				n = n.next;
			}	
		}
		sb.append("null");

		return sb.toString();
	}

	/* Generates a linked list with 
		@length
		@seed
	*/
	public static Stack generate(int length, int seed) {
		Random rand = new Random(seed);

		Stack sk = new Stack();
		for (int i = 0; i < length; i++)
			sk.push(rand.nextInt(50));

		return sk;
	}


	public static void main(String args[]) {
		System.out.println("Hello World.");
		Stack s = generate(5,6);

		s.pop();
		s.pop();
		s.pop();
		
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		System.out.println(s.peek());
	}
}
