/**
  * We wish to implement a Min Heap which keeps your data ordered in an
  * ascending order
  **/

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;


public class MinHeap {

	// This heap will start at position 1
	// Parent Node is at index: 2/k 
	// Left Node is at index: 2k
	// Right Node is at index: 2k + 1
	public ArrayList<Integer> heap = new ArrayList<>();

	public MinHeap() {
		heap.add(Integer.MIN_VALUE);
	}

	// First add the data to the first available slot in the index 
	// Then bubble up.
	// Time Complexity: O(log n)
	public void insert(int data) {
		// Adds
		heap.add(data);

		int idxData = heap.size()-1;

		// Bubble up
		if (idxData != 1) { //Is not the root.
			int idxParent = idxData / 2;
			int parent = heap.get(idxParent);

			while (parent > data) {
				//swap
				int tmp = parent;
				heap.set(idxParent, data);
				heap.set(idxData, tmp);

				//update new parent
				idxParent = idxParent / 2;
				idxData = idxData / 2;
				parent = heap.get(idxParent);

			}
		}
	}

	// Save the root in a variable
	// Replace data of last node at root
	// then bubble down
	public int min() {

		if (heap.size() > 2) {
			//Save and Replace root
			int minValue = heap.get(1);
			heap.set(1, heap.remove(heap.size()-1));

			//Bubble down
			int idxParent = 1;
			int idxLeftChild = 2*idxParent;
			int idxRightChild = 2*idxParent + 1;

			while (idxLeftChild < heap.size()-1 || idxRightChild < heap.size()-1) {
				int rightChild = Integer.MAX_VALUE;
				int leftChild = Integer.MAX_VALUE;

				if (idxRightChild < heap.size()-1)
					rightChild = heap.get(idxRightChild);
				if (idxLeftChild < heap.size()-1)
					leftChild = heap.get(idxLeftChild);
				
				if (leftChild == Integer.MAX_VALUE && rightChild == Integer.MAX_VALUE)
					return minValue;
				else if (leftChild <= rightChild) {
					//Swap
					int tmp = heap.get(idxLeftChild);
					heap.set(idxLeftChild, heap.get(idxParent));
					heap.set(idxParent, tmp);

					//LEFT becomes new parent
					idxParent = idxLeftChild;
				} else { // leftChild > rightChuld
					//Swap
					int tmp = heap.get(idxRightChild);
					heap.set(idxRightChild, heap.get(idxParent));
					heap.set(idxParent, tmp);

					//RIGHT becomes new parent
					idxParent = idxRightChild;
				} 

				idxLeftChild = 2*idxParent;
				idxRightChild = 2*idxParent + 1;
			}

		} 

		return Integer.MIN_VALUE;
	}

	public int size() {
		return heap.size();
	}

	public int get(int index) {
		return heap.get(index);
	}

	public String toString() {
		//heapify
		return Arrays.toString(heap.toArray());
	}

	public static void main(String[] args) {
		MinHeap m = new MinHeap();
		m.insert(5);
		m.insert(14);
		m.insert(23);
		m.insert(32);
		m.insert(41);
		m.insert(87);
		m.insert(90);
		m.insert(50);
		m.insert(64);
		m.insert(53);

		System.out.println(m);
		m.min();
		System.out.println(m);
	}

}
