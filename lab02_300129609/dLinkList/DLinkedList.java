/*  CSI2114 Lab 2 - DLinkedList.java
 *  
 *  Class doubly linked list   
 *  
 *  by Jeff Souza
 *
 */

class DLinkedList {

	ListNode firstNode;
	ListNode lastNode;

	// Appends a node to the end of the list
	void AppendNode(ListNode nNode) {
		InsertNode(nNode,lastNode);
	}

	// Inserts a node into the list after pAfter
	void InsertNode(ListNode nNode, ListNode pAfter) {
		if (pAfter.next != null) {
			pAfter.next.previous = nNode;
			nNode.next = pAfter.next;
			
		} else {
			lastNode = nNode; 
		}
		pAfter.next = nNode;
		nNode.previous = pAfter;
		
	}

	// Removes the specified node from the list
	void RemoveNode(ListNode nNode) {
		if (nNode.previous != null && nNode.next!=null) {
			nNode.previous.next = nNode.next;
			nNode.next.previous = nNode.previous;
		}
		else if (nNode.previous == null && nNode.next==null) {
			nNode = null;
		}
		else if (nNode.previous == null && nNode.next!=null) {
			nNode.next.previous = null;
			firstNode = nNode.next;
		}
		else if (nNode.previous != null && nNode.next == null){
			nNode.previous.next = null;
			lastNode = nNode.previous;
		}
			
	}

	// print the content of the list
	void print() {
		ListNode nNode = null;
		System.out.print("Current list: ");
		for (nNode = firstNode; nNode != null; nNode = nNode.next) {
			System.out.print(nNode.data +  " ");
		}
		System.out.println("");
	} 

}