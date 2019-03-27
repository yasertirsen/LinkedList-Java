package application;
import java.util.Scanner;

import dataStructures.*;

public class Employee {
	
	private String name, course;
	private int id, duration;
	
	public Employee() {
		this.name = "";
		this.course = "";
		this.id = 0;
		this.duration = 0;
	}
	
    public Employee(String name,String course, int id, int duration) {
		this.name = name;
		this.id = id;
	
		Scanner sc = new Scanner(System.in);
		while(duration < 5){
			System.out.println("Duration must be at least 5 years"
					+ "\nPlease enter duration again:"); 
			duration = sc.nextInt(); //Creates a condition that duration must be over 5 years.
		}
		this.duration = duration;
		if(!course.toUpperCase().startsWith("FOOD")) //If course does not start with FOOD then it is converted to ERROR.
			this.course = "ERROR";
		else
			this.course = course.toUpperCase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean equals(Object otherObject) {
		Employee otherEmployee = (Employee) otherObject;
		if(this.name.equals(otherEmployee.getName()) && this.course.equalsIgnoreCase(otherEmployee.getCourse())
				&& this.id == (otherEmployee.getId()) && this.duration ==(otherEmployee.getDuration()))
			return true;
		else
		return false;
	}

	@Override
	public String toString() {
		return "Employee Name: " + name + "\nCourse: " + course + "\nID: " + id + "\nDuration: " + duration;
	}
    
    
	

	

}
