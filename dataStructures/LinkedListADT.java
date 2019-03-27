/*
* File name : EmployeeTraining 
* Author : Yaser Tirsen 
* Student number : D18125793
* Description of class: This class is the Abstract Data Type definition for the Linked List.
*/

//Note that this is not a full definition as we are only implementing some
//of the standard functions associated with a list.

package dataStructures;

public interface LinkedListADT <T>
	{
	   //  Adds one element to the start or end of this list
	   public void add (T element);
	   // Adds an element at any position in the list where position is passed by user
	   public void add (T element, int position);
	   // Removes an element that has been passed in by user
	   public boolean remove(T element);
	   //  Returns true if this list contains no elements
	   public boolean isEmpty();
	   //  Returns the number of elements in this list
	   public int size();
	   // Returns next element in the list
	   public LinearNode<T> returnNext(T element);
	   // Returns the index of the element passed in
	   public int indexOf(T element);
	   // Returns first element in the list
	   public T returnFirst ();
	   // Returns last element in the list
	   public T returnLast ();
	 //Returns the address of the first element in the list
	   public LinearNode<T> returnFirstNode();
	   // Checks if element passed in is in the list
	   public boolean contains(T element);
	   //  Returns a string representation of this list
	   public String toString();
	

}
