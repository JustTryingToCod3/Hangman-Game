package school;
import java.util.Random;

public class LinkedBag<T> implements BagInterface<T> {
	
	
	private static class Node<T>{
		private T nodeData;
		private Node<T> nextNode = null;
		
		public Node(T nodeData) {
			this.nodeData = nodeData;
		}				
	}
	
	private int numberOfElements = 0;
	private Node<T> head = null;
	
	public LinkedBag() {
		
	}
	
	public int getCurrentSize() {
		return numberOfElements;
	}

	
	public boolean isFull() {
		return false;
	}

	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}else {
			return false;
		}
	}

	
	public boolean add(T input) {
		Node<T> newNode = new Node<T>(input);
		newNode.nextNode = head;
		head = newNode;
		numberOfElements++;
		return true;

	}
	
	public T removeRandom() {
		if(isEmpty()) {
			return null;
		}
		else {
		int indexToRemove = new Random().nextInt(numberOfElements);
		return removeAtIndex(indexToRemove);
		}
		
	}

	
	public boolean removeSpecific(T input) {
		int index = getIndexOf(input);
		if(isEmpty()) {
			return false;
		}
		else { 
			removeAtIndex(index);
			return true;
		}
	}

	
	public void removeAll() {
		head = null;
	}

	
	public int getCountOf(T input) {
		if(isEmpty()) {
			return 0;
		}else {
		int count = 0;
		Node<T> currentNode = head;
		while(currentNode !=null) {
			if (currentNode.nodeData.equals(input)){
				count++;
			}
			currentNode = currentNode.nextNode;
		}
		return count;
		}
	}

	
	public boolean contains(T input) {
		if(getIndexOf(input) >= 0) {
			return true;
		}else {
			return false;
		}
	}
	private int getIndexOf(T input) {
		Node<T> currentNode = head;
		int index = 0;
		while(currentNode != null) {
			if (currentNode.nodeData.equals(input)) {
				return index;
			}
			currentNode = currentNode.nextNode;
			index++;
		}
		return -1;
	}
	private T removeAtIndex(int index) {
		if (isEmpty()) {
			return null;
		}
		T removedNode;
		if (index == 0) {
			removedNode = head.nodeData;
			head = head.nextNode;
			return removedNode;
		}
		else {
			Node<T> currentNode = head;
			for (int i = 0; i<index-1; i++) {
				currentNode = currentNode.nextNode;
			}
			removedNode = currentNode.nextNode.nodeData;
			currentNode.nextNode = currentNode.nextNode.nextNode;
			
			numberOfElements--;
			return removedNode;
		}
	}

}
