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
	
	public boolean search(int number){
		Node current=head;
		while(current != null){
			if(current.data == number){
				return true;
			}
			current=current.next;
		}
		return false;
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
	
}
