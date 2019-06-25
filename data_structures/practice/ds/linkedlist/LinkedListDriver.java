package ds.linkedlist;

import ds.linkedlist.LinkedList.Node;

public class LinkedListDriver {

	public static void main(String[] args) {
		LinkedList linkedList=new LinkedList();
		Node node1=new Node(2);
		Node node2=new Node(5);
		Node node3=new Node(8);
		Node node4=new Node(7);
		Node node5=new Node(4);
		linkedList.head=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node2;
		if(linkedList.detectLoopUsingTwoPointer()){
			System.out.println("-- has loop --");
		}else{
			System.out.println("-- no loop --");
		}
		System.out.println("Loop length:"+linkedList.getLoopLength());
		
		LinkedList list2=new LinkedList();
		Node noden1=new Node(2);
		Node  noden2=new Node(3);
		Node noden3=new Node(7);
		Node noden4=new Node(1);
		list2.head=noden1;
		noden1.next=noden2;
		noden2.next=noden3;
		noden3.next=noden4;
		if(list2.checkPalindromeByStack()){
			System.out.println(" list2 is palindrome");
		}else{
			System.out.println(" list2 is not palindrome");
		}
		
		list2.printList();
		list2.reverseList();
		list2.printList();
		
		
		LinkedList sortedList=new LinkedList();
		Node snode1=new Node(1);
		Node snode2=new Node(2);
		Node snode3=new Node(3);
		Node snode4=new Node(5);
		Node snode5=new Node(6);
		sortedList.head=snode1;
		snode1.next=snode2;
		snode2.next=snode3;
		snode3.next=snode4;
		snode4.next=snode5;
		sortedList.printList();
		sortedList.removeDuplicatesFromSortedList();
		sortedList.printList();
		
		sortedList.swap(5, 6);
		sortedList.printList();
		innterSectionTest();
		
	}

	private static void innterSectionTest() {
		LinkedList sortedList=new LinkedList();
		Node snode1=new Node(1);
		Node snode2=new Node(2);
		Node snode3=new Node(3);
		Node snode4=new Node(5);
		Node snode5=new Node(6);
		sortedList.head=snode1;
		snode1.next=snode2;
		snode2.next=snode3;
		snode3.next=snode4;
		snode4.next=snode5;

		LinkedList sortedList1=new LinkedList();
		sortedList1.append(1);
		sortedList1.append(5);
		LinkedList findIntersectionList = sortedList.findIntersectionList(sortedList1);
		System.out.println("-- sorted list1 :---");
		sortedList.printList();
		System.out.println("-- sorted list2 :---");
		sortedList1.printList();
		System.out.println("-- intersecting nodes : --");
		findIntersectionList.printList();
	}
}
