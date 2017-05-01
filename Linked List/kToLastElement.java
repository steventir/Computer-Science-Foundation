public class kToLastElement {

	public static void main(String[] args) {
		LinkedList Ll = new LinkedList();
		Ll = LinkedList.generate(5,5);
		System.out.println(Ll);
		int k = 5;
		System.out.println("k = "+ k +" : " + getKthToLastElem(Ll,k));
	}

	public static Node getKthToLastElem(LinkedList Ll, int k) {
		Node ptr = Ll.head;
		Node runner = Ll.head;

		int count = 1;

		//set the runner
		while (count < k && runner != null) {
			runner = runner.next;	
			count++;
		}

		//k greater than size of linked list
		if (runner == null)
			return null;

		//walk together
		while (runner.next != null) {
			runner = runner.next;
			ptr = ptr.next;
		}

		return ptr;
	}

}
