/**
* The question that we wish to answer:
*
* Q: Design a stack where push(), pop() and min() operate in O(1) time.
*
*
**/

public class StackMin {

	Stack data;
	Stack min;

	public StackMin() {
		data = new Stack();
		min = new Stack();
	}

	public void push(int d) {
		if (!min.isEmpty) {
			if (min.peek() >= d)
				min.push(d);
		} else if (min.head == null)
			min.push(d)
		data.push(d);
	}

	public int pop() {
		int res = -1;
		if (!data.isEmpty()) {
			res = data.pop();
			if (min.peek() == res)
				min.pop();
		}
		return res;
	}

	public int min() {
		return min.peek();
	}

	public int peek() {
		return data.peek();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		StackMin sm = new StackMin();

		sm.push(4);
		sm.push(1);
		sm.push(1);

		System.out.println(sm.data);
		System.out.println(sm.min);

		System.out.println(sm.min());
		sm.pop();
		System.out.println(sm.min());

		System.out.println(sm.data);
		System.out.println(sm.min);

	}
}
