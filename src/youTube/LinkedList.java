package youTube;

public class LinkedList {
	
	public class Node {

		// Set to public so getters & setters aren't needed
		
		public String name;
		public int data;
		
		// Reference to next link made in the LinkList
		// Holds the reference to the Link that was created before it
		// Set to null until it is connected to other links
		
		public Node next; 
		
		public Node(String name, int data){	
			this.name = name;
			this.data = data;
		}
		
		public void display(){
			System.out.println(name + ": " + data);	
		}
		
		public String toString(){
			return name;	
		}
	}
	
	
	
	class LinkList {
		// Reference to first Link in list
		// The last Link added to the LinkedList
		public Node head;

		LinkList() {
			// Here to show the first Link always starts as null
			head = null;
		}

		// Returns true if LinkList is empty
		public boolean isEmpty() {
			return (head == null);
		}

		public void insertFirstLink(String bookName, int millionsSold) {
			Node newLink = new Node(bookName, millionsSold);
			// Connects the firstLink field to the new Link
			newLink.next = head;
			head = newLink;
		}

		public Node removeFirst() {
			Node linkReference = head;
			if (!isEmpty()) {
				// Removes the Link from the List
				head = head.next;
			} else {
				System.out.println("Empty LinkedList");
			}
			return linkReference;
		}

		public void display() {
			Node theLink = head;
			// Start at the reference stored in firstLink and
			// keep getting the references stored in next for
			// every Link until next returns null

			while (theLink != null) {
				theLink.display();
				System.out.println("Next Link: " + theLink.next);
				theLink = theLink.next;
				System.out.println();

			}

		}
		public Node find(String bookName) {
			Node theLink = head;
			if (!isEmpty()) {
				while (theLink.name != bookName) {
					// Checks if at the end of the LinkedList
					if (theLink.next == null) {
						// Got to the end of the Links in LinkedList
						// without finding a match
						return null;
					} else {
						// Found a matching Link in the LinkedList

						theLink = theLink.next;
					}
				}
			} else {
				System.out.println("Empty LinkedList");
			}
			return theLink;
		}

		public Node removeLink(String bookName) {
			Node currentLink = head;
			Node previousLink = head;
			// Keep searching as long as a match isn't made
			while (currentLink.name != bookName) {
				// Check if at the last Link in the LinkedList
				if (currentLink.next == null) {
					// bookName not found so leave the method
					return null;
				} else {
					// We checked here so let's look in the
					// next Link on the list
					previousLink = currentLink;
					currentLink = currentLink.next;
				}
			}
			if (currentLink == head) {
				// If you are here that means there was a match
				// in the reference stored in firstLink in the
				// LinkedList so just assign next to firstLink
				head = head.next;
			} else {
				// If you are here there was a match in a Link other
				// than the firstLink. Assign the value of next for
				// the Link you want to delete to the Link that's
				// next previously pointed to the reference to remove
				System.out.println("FOUND A MATCH");
				System.out.println("currentLink: " + currentLink);
				System.out.println("firstLink: " + head);
				previousLink.next = currentLink.next;
			}
			return currentLink;
		}
	}
}
