package org.jsp.courseregisteration;

import java.util.ArrayList;
import java.util.List;
public class Course 
	{

		    String code;
		    String title;
		    int capacity;
		    List<Student> enrolledStudents;

		    public Course(String code, String title, int capacity) {
		        this.code = code;
		        this.title = title;
		        this.capacity = capacity;
		        this.enrolledStudents = new ArrayList<>();
		    }

		    public boolean enrollStudent(Student student) {
		        if (enrolledStudents.size() < capacity) {
		            enrolledStudents.add(student);
		            return true;
		        } else {
		            System.out.println("Course is full. Cannot enroll student.");
		            return false;
		        }
		    }

		    public void removeStudent(Student student) {
		        enrolledStudents.remove(student);
		    }

		    public String toString() {
		        return "Course Code: " + code + "\nTitle: " + title + "\nCapacity: " + capacity +
		                "\nEnrolled Students: " + enrolledStudents.size();
		    }
		}

		
