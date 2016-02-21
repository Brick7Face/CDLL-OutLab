
public class Node {
	private Node next;			//next in list
	private Student student;	//actual data in node
	
	public Node(Student s) {
		student = s;
		next = null;
	}
	
	public void setNext(Node n) {
		next = n;		//sets next reference node
	}
	public Node getNext() {
		return next;	//returns the next node in the list
	}
	public String getName() {
		return student.getName();		//returns name for comparison
	}
	public int getId() {
		return student.getId();			//returns ID for comparison
	}
	public String toString() {			//prints info in a string if called
		return student.getName() + ", " + student.getId();
	}
}
