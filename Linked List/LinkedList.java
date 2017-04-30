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

class LinkedList {
	Node head;
	Node tail;
	int size;

	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/* appends the node to the end of the list, SPEED : O(1) */
	public void add(int d) {
		if (size == 0) {
			head = new Node(d);
			tail = head;
		}
		else {
			Node newNode = new Node(d);
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	/* Delete in O(n) as it traverses all the nodes*/
	public void remove(int d) {
		//delete a single node
		if (this.size == 1) {
			this.size--;
			head = null;
			tail = null;
		} else {
			Node n = this.head;
			while (n != null && n.next != null) {
				if (n.next.data == d) {
					if (n.next.next != null) { // deleting in middle of list
						n.next = n.next.next;
						n.next.next = null;
					} else { //deleting at end of llist
						n.next = null;
						tail = n;
					}
					size--;
				}
				n = n.next;
			}
		}
	}


	/* Get size */
	public int size() {
		return size;
	}

	/* Generates a linked list with 
		@length
		@seed
	*/
	public static LinkedList generate(int length, int seed) {
		Random rand = new Random(seed);

		LinkedList Ll = new LinkedList();
		for (int i = 0; i < length; i++)
			Ll.add(rand.nextInt(50));

		return Ll;
	}

	public static void main(String args[]) {
		LinkedList genList = generate(5,5);
		Node x = genList.head;

		while (x != null) {
			System.out.println(x);
			x = x.next;
		}

		//LinkedList Ll = new LinkedList();
		//Ll.remove(2);

		//Ll.add(1);
		//Ll.add(2);
		//Ll.add(3);

		//Node n = Ll.head;
		//while (n != null) {
		//	System.out.println(n);
		//	n = n.next;
		//}
		//Ll.remove(3);

		//System.out.println("Linkedlist after removal");

		//n = Ll.head;
		//while (n != null) {
		//	System.out.println(n);
		//	n = n.next;
		//}
	}

}
