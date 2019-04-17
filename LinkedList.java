import java.io.*;

public class LinkedList {
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void insert(LinkedList list, int data) {
		Node newNode = new Node(data);
		if (list.head==null) {
			list.head = newNode;
		} else {
			Node last = list.head;
			while (last.next!=null) {
				last = last.next;			
			}
			last.next = newNode;
		}
	}

	public static void removeTail(LinkedList list) {
		Node currentNode = list.head;
		Node previousNode = currentNode;
		while (currentNode!=null) {
			if (currentNode.next!=null)
				previousNode = currentNode;
			currentNode = currentNode.next;			
		}
		previousNode.next = null;
	}	

	public static void removeGreater(LinkedList list, int target) {
		Node currentNode = list.head;
		if (currentNode.data > target) {
			if (currentNode.next==null) {
				list.head = null;
				return;
			} else {
				list.head = currentNode.next;
			}
		}
		Node previousNode = currentNode;
		while (currentNode!=null) {
			if (currentNode.data > target) {
				if (currentNode.next!=null) {
					previousNode.next = currentNode.next;					
				} else {
					previousNode.next = null;
				}
				currentNode = previousNode;
			}
			if (currentNode.next!=null)
				previousNode = currentNode;
			currentNode = currentNode.next;			
		}		
	}	
	
	public static void printList(LinkedList list) {
		Node currentNode = list.head;
		while (currentNode!=null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList(); 
		list.insert(list, 3);
		list.insert(list, 2);
		list.insert(list, 3);
		list.insert(list, 4);
		list.insert(list, 1);
		System.out.println("Printing list");
		printList(list);
		list.removeTail(list);
		System.out.println("Printing list after remove tail element");		
		printList(list);		
		list.removeGreater(list,2);
		System.out.println("Printing list after remove anything greater than target");
		printList(list);
	}

}
