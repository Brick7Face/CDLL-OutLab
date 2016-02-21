import java.util.Scanner;

public class LinkedList {			//class that controls linked list
	private Node first;				//first Node
	private Node last;				//last Node
	private Scanner in;				//got rid of a warning putting this here instead of locally in menu()

	public LinkedList() {			//constructor makes list and sets first and last to null
		first = last = null;
	}
	public void menu() {
		int option = 0;		//choice variable
		in = new Scanner(System.in);
		do {			//generates menu options with one print line until user chooses -1
			System.out.print("\nWhat would you like to do?\nPress 1 to add an item\nPress 2 to print the list\nPress 3 to search the list\nPress 4 to delete an item\nPress 5 to clear the whole list\nPress -1 to exit\n> ");
			option = in.nextInt();		//sets choice to user's input (assuming they enter an integer)
			if (option == 0 || option > 5) {	//catches invalid integers
				System.out.println("\nInvalid input.");
			}
			switch(option) {
			case 1: {		//adds another node to end of list	
				System.out.print("\nEnter the name of the student > ");	//new line before println's for readability
				String name = in.next();
				in.nextLine();
				System.out.print("\nEnter the ID of the student > ");
				int iD = in.nextInt();
				add(new Node(new Student(iD, name)));				//calls method after reading in necessary info
				break;
			}
			case 2: print(); break;		//prints list
			case 3: {					//search list
				System.out.print("\nEnter the name of the student you want to search > ");
				String input = in.next();
				if (search(input) == false) System.out.println("\nNot found.");		//if true, prints from method
				break;
			}
			case 4: {		//removes specified node
				System.out.print("\nEnter the name of the student you want to remove > ");
				String name = in.next();
				in.nextLine();		//uses name of student to delete, since asking user to enter info for toString() never worked perfectly
				if (remove(name) == false) System.out.println("\nNot found.");	//if true, prints from method
				break;
			}
			case 5: clear(); break;		//clears list
			case -1: System.out.println("\nGoodbye!"); break;		//exits menu loop
			}
		}
		while (option != -1);
	}
	public void add(Node input) {		//adds node to end of list and starts one if list is empty
		if (first == null) {
			first = input;
			last = first;
		}
		else {
			last.setNext(input);
			last = last.getNext();
		}
	}
	public void print() {		//prints list info
		Node iter = first;
		while (iter != null) {
			System.out.println("\n" + iter.toString());
			iter = iter.getNext();
		}
		if (first == null) System.out.println("\nList empty.");
	}
	public boolean remove(String input) {		//removes specified node and reconnected references
		Node iter = first;
		Node lag = first;
		while(iter != null) {
			if(input.equals(iter.getName())) {
				System.out.println("\nStudent removed: " + iter.toString());
				if (iter == first){
					Node temp = iter.getNext();
					first = temp;
					iter.setNext(null);
				}
				else if (iter == last) {
					lag.setNext(null);
					last = lag;
				}
				else {
					lag.setNext(iter.getNext());
					iter.setNext(null);
				}
				return true;
			}
			else {
				lag = iter;
				iter = iter.getNext();
			}
		}
		return false;
	}
	public void clear() {		//clears list by setting first and last equal to null
		first = null;
		last = null;
		System.out.println("\nAll clear.");
	}
	public boolean search(String name) {	//searches list for input, if matches prints info from toString() in Node class
		Node iter = first;
		while(iter != null) {
			if(name.equals(iter.getName())) {
				System.out.println("\n" + iter.toString());
				return true;
			}
			else iter = iter.getNext();
		}
		return false;
	}
}
