package linkedlist;



public class LinkedList {

	Node head;
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
	}
	
	public void printList(){
		System.out.println(" -- iterating list -- ");
		Node next=head;
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
}
