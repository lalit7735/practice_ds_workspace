package ds.linkedlist;

import java.util.Stack;



public class LinkedList {

	Node head;
	private Stack<Integer> nodeStack;
	static class Node{
		int data;
		Node next;
		public Node(int value) {
			data=value;
		}
	}
	
	public static void main(String[] args) {
		LinkedList linkList=new LinkedList();
		linkList.head=new Node(10);
		Node node1=new Node(20);
		Node node2=new Node(30);
		Node node3=new Node(40);
		Node node4=new Node(50);
		
		linkList.head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		System.out.println("linked list created");
		
		linkList.printList();
		
		System.out.println("Mid element:"+linkList.getMiddleElement());
		
		linkList.push(9);
		linkList.printList();
		
		linkList.append(60);
		linkList.printList();
		
		linkList.insertAfter(node2,(node2.data+5));
		linkList.printList();
		
		linkList.delete(40);
		System.out.println("-- afterDeletion --");
		linkList.printList();
		
		Node prevNode = linkList.searchForPrevNode(9);
		System.out.println(prevNode!=null?"exists":"not exists");
		
		//linkList.deleteLinkedList();
		//linkList.printList();
		System.out.println("size of list using iteration:"+linkList.getSize());
		System.out.println("size of list using recurssion:"+linkList.getSize(linkList.head));
		
		System.out.println("is 5 exists :"+linkList.search(5));
		System.out.println("is 35 exists :"+linkList.search(5));
		
		System.out.println("is 5 exists :"+linkList.search(linkList.head,5));
		System.out.println("is 35 exists :"+linkList.search(linkList.head,35));
		
		System.out.println(" element at 0th:"+linkList.get(0).data);
		System.out.println(" element at 3th:"+linkList.get(3).data);
		
		System.out.println(" last third of list :"+linkList.getLast(3).data);
		System.out.println(" last third of list :"+linkList.getLast(1).data);
		System.out.println(" last third of list using two pointer approach:"+linkList.getLastUsingTwoPointer(15).data);
		
	}
	
	public void printList(){
		System.out.println(" -- iterating list -- ");
		Node next=head;
		if(head == null){
			System.out.println("no data in list");
		}
		while(next!=null){
			System.out.println(next.data);
			next=next.next;
		}
	}
	
	public int getMiddleElement(){
		Node slow=head;
		Node fast=head;
		while(fast.next!=null){
			slow=slow.next;
			fast=slow.next.next;
		}
		return slow.data;
	}
	public Node getLastNode(){
		Node lastNode=head;
		while(lastNode!=null && lastNode.next!=null){
			lastNode=lastNode.next;
		}
		return lastNode;
	}
	public void append(int data){
		Node node=new Node(data);
		Node lastNode = getLastNode();
		if(lastNode == null){
			push(data);
			return;
		}
		lastNode.next=node;
	}
	
	public int getSize(){
		int  count=0;
		Node next=head;
		while(next!=null){
			count++;
			next=next.next;
		}
		return count;
	}
	
	public int getSize(Node head){
		if(head == null){
			return 0;
		}
		return 1 + getSize(head.next);
	}	
	/*
	 * This method will insert a node at start of linked  list
	 */
	public Node push(int data){
		Node node=new Node(data);
		node.next=head;
		head=node;
		return node;
	}
	
	public void insertAfter(Node prevNode,int value){
		if(prevNode.next==null){
			append(value);
		}else{
			Node nodeToInsert=new Node(value);
			nodeToInsert.next=prevNode.next;
			prevNode.next=nodeToInsert;
		}
	}
	
	public Node searchForPrevNode(int value){
		Node prev = head;
		Node search = head;
		while(search!=null){
			if(search.data == value){
				return prev;
			}
			prev=search;
			search=search.next;
		}
		return null;
	}
	
	public void deleteLinkedList(){
		head=null;
	}
	public void delete(int  value){
		Node prevNode = searchForPrevNode(value);
		if(prevNode!=null){
			prevNode.next=prevNode.next.next;
		}
	}
	
	public void deleteAtIndex(int index){
		Node nodeToDelete=null;
		Node node=head;
		int index1=-1;
		while(node!=null){
			index1++;
			if(index == index1){
				nodeToDelete=node;
				break;
			}
			node=node.next;
		}
		delete(nodeToDelete.data);
	}
	
	public Node search(int number){
		Node current=head;
		while(current != null){
			if(current.data == number){
				return current;
			}
			current=current.next;
		}
		return null;
	}
	
	public boolean search(Node head,int number){
		if(head == null){
			return false;
		}
		else if(head.data == number){
			return true;
		}
		return search(head.next,number); 
	}
	
	public Node get(int index){
		int count = 0;
		Node current = head;
		while(current != null){
			if(count == index){
				return current;
			}
			current=current.next;
			count++;
		}
		return null;
	}
	
	public Node getLast(int index){
		int size = getSize();
		return get(size-index);
	}
	
	public Node getLastUsingTwoPointer(int index){
		Node refNode=head;
		Node mainNode=head;
		int count=0;
		while(refNode!=null){
			if(count != index){
				refNode=refNode.next;
				count++;
			}else{
				refNode=refNode.next;
				mainNode=mainNode.next;
			}
		}
		return mainNode;
	}
	
	public boolean detectLoopUsingTwoPointer(){
		Node slow=head;
		Node fast=head;
		while(fast!=null){
			slow=slow.next;
			fast=fast.next!=null?fast.next.next:fast.next;
			if(fast == slow){
				return true;
			}
		}
		return false;
	}
	
	public int getLoopLength(){
		int loopCounter=0;
		Node slow=head;
		Node fast=head;
		while(fast!=null){
			slow=slow.next;
			fast=fast.next!=null?fast.next.next:fast.next;
			if(fast == slow){
			 loopCounter++;
			 break;
			}
		}
		if(loopCounter > 0){
			Node fixedPoint=slow;
			Node movingPoint=slow.next;
			while(movingPoint!=fixedPoint){
				loopCounter++;
				movingPoint=movingPoint.next;
			}
		}
		return loopCounter;
	}
	 
	public boolean checkPalindromeByStack(){
		boolean isPalindrome = false;
		nodeStack=new Stack<Integer>();
		Node start1=head;
		Node start2=head;
		while(start1!=null){
			nodeStack.push(start1.data);
			start1=start1.next;
		}
		
		while(start2!=null){
			Integer pop = nodeStack.pop();
			if(pop == start2.data){
				isPalindrome = true;
			}else{
				isPalindrome=false;
				break;
			}
			start2=start2.next;
		}
		return isPalindrome;
	}

	public Stack<Integer> getNodeStack() {
		return nodeStack;
	}

	public void setNodeStack(Stack<Integer> nodeStack) {
		this.nodeStack = nodeStack;
	}
	
	public void removeDuplicatesFromSortedList(){
		Node slow=head;
		Node fast=head.next;
		int nodeCounter=1;
		while(fast!=null){
			if(slow.data == fast.data){
				fast=fast.next;
				this.deleteAtIndex(nodeCounter);
			}else if(slow != fast){
				slow=slow.next;
				fast=fast.next;
			}
		}
	}
	
	public void reverseList(){
		Node current=head;
		Node n1 = null; // this will hold reverse list
		while(current!=null){
			Node c1=current.next;
			current.next=n1;
			n1=current;
			current=c1;		
		}
		head=n1;
	}
	
	public void swap(int num1,int num2){
		Node node1 = search(num1);
		Node node2=search(num2);
		if(node1!=null && node2!=null){
			Node prevNode1 = searchForPrevNode(num1);
			Node prevNode2 = searchForPrevNode(num2);
			Node nextNode1=node1.next;
			Node nextNode2=node2.next;
			prevNode1.next=node2;
			prevNode2.next=node1;
			Node temp = node1.next; 
			node1.next = node2.next; 
			node2.next = temp;
		}
	}

	public void printCircularList() {
		System.out.println(" -- iterating list -- ");
		Node startPoint=head;
		Node current=head;
		do{
			System.out.println(current.data);
			current=current.next;
		}
		while(current!=head);
	}
	
	public void createTwoHalvesOfCircularLs(){
		// get middle using two pointer
		// get last of the list
		//set middle next to head of list , will gives first list
		// set next of last , to next of mid and next of mid will be head of second list
		
		Node firstPointer=head;
		Node secondPointer=head;
		Node mid=null;
		Node last=null;
		do{
			firstPointer=firstPointer.next;
			secondPointer=secondPointer.next.next;
			if(secondPointer.next == head || secondPointer.next.next==head){
				mid=firstPointer;
				last=secondPointer.next==head?secondPointer:secondPointer.next;
				break;
			}
		}
		while(secondPointer!=head);
		//System.out.println("mid:"+mid.data);
		LinkedList list1=new LinkedList();
		list1.head=head;
		Node newHead=mid.next;
		mid.next=head;
		list1.printCircularList();
		
		LinkedList list2=new LinkedList();
		list2.head=newHead;
		last.next=newHead;
		list2.printCircularList();
	}
	
	public void insertIntoSortedCircularList(int num){
		Node start=head;
		do{
			if((start.data<=num && start.next!=null && start.next.data>=num)
					|| start.next==head){
				Node node=new Node(num);
				node.next=start.next;
				start.next=node;
				break;
			}else if(start==head && start.data>num){
				// create new node as head
				Node  node=new Node(num);
				node.next=head;
				head=node;
				break;
			}
			start=start.next;
		}while(start!=head);
	}
	
	public boolean isCircular(){
		Node start=head;
		start=start.next;
		while(start!=null && start!=head){
			start=start.next;
		}
		return (start == head);
	}
	
	public LinkedList findIntersectionList(LinkedList list){
		LinkedList result=new LinkedList();
		Node start1=this.head;
		Node start2=list.head;
		while(start1!=null && start2!=null){
			if(start1.data == start2.data){
				result.push(start1.data);
				start1=start1.next;
				start2=start2.next;
			}else if(start2.data>start1.data){
				start1=start1.next;
			}else{
				start2=start2.next;
			}
		}
		return result;
	}
	
	public void exhangeFirstLastInCircularList(){
		Node last=head;
		Node previous=null;
		do{
			previous=last;
			last=last.next;
		}while(last.next!=head);
		// swap head  and last node
		Node temp=head;
		head=last;
		last=temp;
	}
}
