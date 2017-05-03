public class StackMin {

	Stack data;
	Stack min;

	public StackMin() {
		data = new Stack();
		min = new Stack();
	}

	public void push(int d) {
		if (!min.isEmpty()) {
			if (min.peek() > d)
				min.push(d);
		}	
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
		if (!min.isEmpty())
			return min.peek();
		return -1;
	}

	public int peek() {
		return data.peek();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
