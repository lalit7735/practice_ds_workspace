package ds.linkedlist;

import ds.linkedlist.LinkedList.Node;

public class CircularLinkedListDriver {

	public static void main(String[] args) {
		LinkedList linkList=new LinkedList();
		LinkedList.Node head=new LinkedList.Node(2);
		linkList.head=head;
		linkList.append(2);
		//linkList.append(3);
		linkList.append(4);
		//linkList.append(5);
		linkList.append(6);
		//linkList.append(7);
		linkList.append(8);
		//linkList.append(9);
		linkList.append(10);
		//linkList.append(11);
		linkList.append(12);
		linkList.append(13);
		Node lastNode = linkList.getLastNode();
		lastNode.next=head;
		
		//linkList.printCircularList();
		//linkList.createTwoHalvesOfCircularLs();
		
		System.out.println("-- before adding to sorted list :");
		linkList.printCircularList();
		System.out.println("-- after adding to sorted list :");
		//linkList.insertIntoSortedCircularList(7);
		//linkList.insertIntoSortedCircularList(3);
		linkList.insertIntoSortedCircularList(14);
		linkList.printCircularList();
		System.out.println(linkList.isCircular());
		linkList.exhangeFirstLastInCircularList();
		linkList.printCircularList();
	}
}
