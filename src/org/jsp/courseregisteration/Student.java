package org.jsp.courseregisteration;

import java.util.*;



public class Student {

	
	    String studentID;
	    String name;

	    public Student(String studentID, String name) {
	        this.studentID = studentID;
	        this.name = name;
	    }

	    public String toString() {
	        return "Student ID: " + studentID + "\nName: " + name;
	    }
	}
