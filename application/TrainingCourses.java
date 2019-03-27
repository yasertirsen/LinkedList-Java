/*
* Description of class: This class is used to input and display various info about the training courses.
* It is the driver class for Employee class.
*/
package application;
import java.util.Scanner;

import dataStructures.LinearNode;
import dataStructures.LinkedList;

public class TrainingCourses {
	
	LinkedList<Employee> list;
	final int capacity = 10;
	int numOfEmployees;
	Scanner sc = new Scanner(System.in);
	
	public TrainingCourses() {
		//Creates a LinkedList of employees
		list = new LinkedList<Employee>();
		System.out.println("How many employees do you want to add:");
		numOfEmployees = sc.nextInt(); //Takes the number of employees to create.
		
		for(int i=0; i<numOfEmployees; i++) {
			addAnEmployee(i); //Passes number to a class to create an employee.
		}
		
		System.out.println();
		System.out.println("The employees are");
		//Calling of various methods that do specific tasks.
		displayEmployees();
		Employee emp = new Employee();
		removeAnEmployee(emp);
		System.out.println("Employees after deletion are:");
		displayEmployees();
		removeEmployeesCourse();
		System.out.println("Remaining employees after course deletion are:");
		displayEmployees();
		System.out.println();
		index(emp);
		displayElements(emp);
	}
	// Creates and adds an employee to the end of the list.
	public void addAnEmployee(int i) {
		Employee employee = new Employee();
		String name, course;
		int id, duration,empNo;
		empNo = i+1;
		if(numOfEmployees < capacity){
		System.out.println("-Employee " + empNo + "- " + "Name:");
		name = sc.next();
		System.out.println("-Employee " + empNo + "- " +"Course:");
		course = sc.next();
		System.out.println("-Employee " + empNo + "- " +"ID:");
		id = sc.nextInt();
		System.out.println("-Employee " + empNo + "- " +"Duration:");
		duration = sc.nextInt();
		employee = new Employee(name, course, id, duration);
		}
		
		while(list.contains(employee) == true){
			System.out.println("Employee already in the list");
			addAnEmployee(i); //Traps user until they enter a unique employee.
			}
		//If employee is not in the list, then it is added to it
		if(list.contains(employee) == false)
			list.add(employee);
		
		if(numOfEmployees > capacity) {
			System.out.println("Maximum number of employees is " + capacity);
			System.exit(0); //If the number of employees is higher than the capacity, an appropriate message appears 
							//and code does not run
		}
		
	}
	// Creates and adds an employee to the end of the list.
		public void addEmployeePosition(int i) {
			Employee employee = new Employee();
			String name, course;
			int id, duration, position = 0, empNo;
			empNo = i+1;
			if(numOfEmployees < capacity){
			System.out.println("-Employee " + empNo + "- " + "Position:");
			position = sc.nextInt();
			System.out.println("-Employee " + empNo + "- " + "Name:");
			name = sc.next();
			System.out.println("-Employee " + empNo + "- " +"Course:");
			course = sc.next();
			System.out.println("-Employee " + empNo + "- " +"ID:");
			id = sc.nextInt();
			System.out.println("-Employee " + empNo + "- " +"Duration:");
			duration = sc.nextInt();
			employee = new Employee(name, course, id, duration);
			}
			
			while(list.contains(employee) == true){
				System.out.println("Employee already in the list");
				addAnEmployee(i); //Traps user until they enter a unique employee.
				}
			//If employee is not in the list, then it is added to it
			if(list.contains(employee) == false)
				list.add(employee, position);
			
			if(numOfEmployees > capacity) {
				System.out.println("Maximum number of employees is " + capacity);
				System.exit(0); //If the number of employees is higher than the capacity, an appropriate message appears 
								//and code does not run
			}
			
		}
	
	//Displays the next element of the employee passed in
	//Displays first employee in the list
	//Displays last employee in the list
	public void displayElements(Employee emp) {
		String name, course;
		int id, duration;
		System.out.println("Please enter employee to find next one");
		System.out.println("Name:");
		name = sc.next();
		System.out.println("Course:");
		course = sc.next();
		System.out.println("ID:");
		id = sc.nextInt();
		System.out.println("Duration:");
		duration = sc.nextInt();
		//Creates a new employee
		emp = new Employee(name, course, id, duration);
		if (list.returnNext(emp) == null)
			System.out.println("No such employee or no next employee");
		else
			System.out.println("Next employee in the list is: " + "\n" + list.returnNext(emp).getElement().getId());
		
		System.out.println("First employee in the list is: " + "\n" + list.returnFirst().getId());
		System.out.println("Last employee in the list is: " + "\n" + list.returnLast().getId());
	}
	public void removeEmployeesCourse(){
		LinearNode<Employee> current;
		Employee deletedEmployee;
		
		String course;
		boolean found = false;
		
		if (list.isEmpty())
			System.out.println("No employees on training");
		else
		{
			
			System.out.print("\nEnter course whose employees to be deleted: ");
			course = sc.next();
			current = list.returnFirstNode();
			do
			{
				current = list.returnFirstNode();
				while(current != null && !current.getElement().getCourse().equalsIgnoreCase(course))
					current = current.getNext();
		
				
				if (current != null && current.getElement().getCourse().equalsIgnoreCase(course))
				{	
					deletedEmployee = current.getElement();
					list.remove(current.getElement());
					found = true;
					System.out.println("Employee " + deletedEmployee.getId() +
							" has been deleted");
				}
			}while (current != null);
			if (!found)
				System.out.println("There were no employees registered on course " + course);
		}
	}
	//Creates a new employee and finds its position in the list
	public void index(Employee emp) {
		String name, course;
		int id, duration;
		System.out.println("Please enter employee to find index");
		System.out.println("Name:");
		name = sc.next();
		System.out.println("Course:");
		course = sc.next();
		System.out.println("ID:");
		id = sc.nextInt();
		System.out.println("Duration:");
		duration = sc.nextInt();
		//Creates a new employee
		emp = new Employee(name, course, id, duration);
		if(list.indexOf(emp) > 0)
		System.out.println("Position of employee " + emp.getId() + " is: " + list.indexOf(emp));
		
	}
	// Displays all employees in the list
	public void displayEmployees() {
		if(list.isEmpty())
			System.out.println("No employees to display, list is empty");
		else
		System.out.println(list.toString());
	}
	// Removes an employee that is entered by user
	public void removeAnEmployee(Employee emp) {
		if(!list.isEmpty()) {
			
			String name, course;
			int id, duration;
			System.out.println("Please enter employee to be removed");
			System.out.println("Name:");
			name = sc.next();
			System.out.println("Course:");
			course = sc.next();
			System.out.println("ID:");
			id = sc.nextInt();
			System.out.println("Duration:");
			duration = sc.nextInt();
			//Creates a new employee
			emp = new Employee(name, course, id, duration);
			//Return true of false if the employee in the list or not
			boolean found = list.remove(emp);
			
			if(!found)
				System.out.println("No such employee to delete");
			
			else{
				list.remove(emp);
				System.out.println("Employee " + emp.getName() + " has been deleted");
				
			
		}
	}
		else
			System.out.println("There are no values to delete");
		
	}
	
	
	public static void main(String[] args) {
		new TrainingCourses();

	}

}
