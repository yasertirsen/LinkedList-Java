/*
* File name : EmployeeTraining 
* Author : Yaser Tirsen 
* Student number : D18125793
* Description of class: This class is the data structure used to store the employee objects.
*/
package dataStructures;
//This class implements the ADT definition of a linked list using the same signatures. Note that we can add extra methods
//here once all of the methods listed in the ADT interface are included.

public class LinkedList<T> implements LinkedListADT<T> {
	
	 private int count;  // the current number of elements in the list
	 private LinearNode<T> list; //pointer to the first element 
	 private LinearNode<T> last; //pointer to the last element 
	 
	
	 	//Creates an empty list.
	    public LinkedList()
	    {
	       this.count = 0;
	       this.last = null;
	       this.list = null;
	    }

	    
	    //Adds one element to the end of this list
	   public void add (T element)
	   {      
		   
		   LinearNode<T> node = new LinearNode<T> (element); 
       
		   if (size() == 0) {  
			   	this.last = node; // This is the last and the 
			 	this.list = node; // first node
			 	this.count++;
		   }
		   else
		  { 
				last.setNext(node); // add node to the end of the list
				last = node; // now make this the new last node.
				count++;   
		  }     
	   }
	   //Adds an employee at a certain position in the list
	   public void add (T element ,int pos) {
    	   LinearNode<T> current = list ;
		   LinearNode<T> previous = list ;
		   LinearNode<T> node = new LinearNode<T> (element); 
		   
		   if (size() == 0) {  
			   	last = node; // This is the last and the 
			 	list = node; // first node
			 	count++;
		   }//end if
		   else
			 //if element is not already in list
			  if (!(contains(element)))
				  
			  { 
			   
			 
				  if (pos == 1)  //if element is at position 1 then add it to the start
				  {
					  node.setNext(list);
					  list = node;
				  }
				  else if (pos == (size() + 1)) //add element to the end
				  {
					  last.setNext(node);
					  last = node;
				  }
							
				  else  //add element in middle of list by finding address of current
				  {
					  for (int i = 1; i< pos; i++)
					   {
						   previous = current;  //previous will go to left of new node
						   if (current != null)
							   current = current.getNext(); //current will go to right
							   
				  }
					  previous.setNext(node);
					  node.setNext(current);
					  
				  }
				  count++; 
			  }	
	   }
	   
	   
	   // Returns the next object of the element passed in
	   public LinearNode<T> returnNext(T element)
	   {      
		   LinearNode<T> current = list;
		   
		 
		   while(current != null && !current.getElement().equals(element) ){
				current = current.getNext();
			}
		   
		   if (current == null)
			   return null;
		   
			else if(current.getElement().equals(element) )
				return current.getNext();
			
			return null;
			
	   }
	   //Returns the index of the element passed in
	   public int indexOf(T element) {
		   LinearNode<T> current = list;
		   int index = 1;
		   
		   if(list.getElement().equals(element))
			   return index;
		   else {
		   while(current != null && !current.getElement().equals(element) ){
				current = current.getNext();
				index++;
			}
		   if(current != null)
		   return index;
		   else
			 //If employee passed in is not in list appropriate message appears.
			   System.out.println("No such employee in the list"); 
		   }
		   return 0;
	   }
	   // Returns first object in the list
	   public T returnFirst()
	   {      
		   T first = this.list.getElement();
		   return first; 
	   }
	// Returns first object in the list
	   public T returnLast()
	   {      
		   T end = this.last.getElement();
		   return end; 
	   }
	   //Returns the address of the first element in the list
	   public LinearNode<T> returnFirstNode()
	   {
		   if (isEmpty())
			   return null;
		   else
			   return list;
	   }
	
	   public boolean remove(T element)
	   {
		boolean found = false;
		LinearNode<T> current = list;
		LinearNode<T> previous = list;
		while(current != null && !current.getElement().equals(element)){
			previous = current;
			current = current.getNext();
		}
			if(current != null){
				if(current == list){
					list = current.getNext();
					current.setNext(null);
					count--;
					found = true;
				}
				else if(current == last){
					last = previous;
					last.setNext(null);
					count--;
					found = true;
				}
				else{
					previous.setNext(current.getNext());
					count--;
					found = true;
				}
				
			}
			return found;
	   }
	   //  Returns true if this list contains no elements
	   public boolean isEmpty()
	   {
		   if (this.list == null)
			   return true;
		   else
			   return false;
	   }

	   //  Returns the number of elements in this list
	   public int size()
	   {
		   return this.count;
	   }
	   
	   
	   public boolean contains(T element){
		   LinearNode<T> current;
		   boolean found = false;
		   //Searches the list for the element and returns true or false accordingly.
		   for(current = list; current != null; current = current.getNext()){
			   if(current.getElement().equals(element)){
				   found = true;
			   }   
		   }
			   return found;
	   }

	   //  Returns a string representation of this list
	   public String toString()
	   {
		   LinearNode<T> current = this.list;
		   String fullList = "";
		   
		   for (current = this.list; current != null; current = current.getNext())
		   {
			   fullList = fullList + "\n" + current.getElement().toString();
		   }
		   return fullList + "\n";
	   }
}
