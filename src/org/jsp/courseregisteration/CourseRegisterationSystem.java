package org.jsp.courseregisteration;
import java.util.*;

public class CourseRegisterationSystem {

	    public static void main(String[] args) {
	        List<Course> courses = new ArrayList<>();

	        Course cs101 = new Course("CS101", "Introduction to Programming", 30);
	        Course math201 = new Course("MATH201", "Calculus I", 25);

	        courses.add(cs101);
	        courses.add(math201);

	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1. Display Courses");
	            System.out.println("2. Enroll Student");
	            System.out.println("3. Remove Student");
	            System.out.println("4. Quit");

	            System.out.print("Enter your choice (1-4): ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    displayCourses(courses);
	                    break;

	                case 2:
	                    enrollStudent(courses, scanner);
	                    break;

	                case 3:
	                    removeStudent(courses, scanner);
	                    break;

	                case 4:
	                    System.out.println("Goodbye!");
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
	            }
	        }
	    }

	    private static void displayCourses(List<Course> courses) {
	        for (Course course : courses) {
	            System.out.println(course);
	            System.out.println("---------------");
	        }
	    }

	    private static void enrollStudent(List<Course> courses, Scanner scanner) {
	        System.out.print("Enter student ID: ");
	        String studentID = scanner.nextLine();

	        System.out.print("Enter student name: ");
	        String studentName = scanner.nextLine();

	        Student student = new Student(studentID, studentName);

	        System.out.println("Available Courses:");
	        displayCourses(courses);

	        System.out.print("Enter the course code to enroll in: ");
	        String courseCode = scanner.nextLine();

	        Course selectedCourse = findCourseByCode(courses, courseCode);

	        if (selectedCourse != null) {
	            selectedCourse.enrollStudent(student);
	            System.out.println("Enrollment successful.");
	        } else {
	            System.out.println("Course not found.");
	        }
	    }

	    private static void removeStudent(List<Course> courses, Scanner scanner) {
	        System.out.print("Enter student ID to remove: ");
	        String studentID = scanner.nextLine();

	        for (Course course : courses) {
	            for (Student student : course.enrolledStudents) {
	                if (student.studentID.equals(studentID)) {
	                    course.removeStudent(student);
	                    System.out.println("Student removed from the course.");
	                    return;
	                }
	            }
	        }

	        System.out.println("Student not found in any course.");
	    }

	    private static Course findCourseByCode(List<Course> courses, String courseCode) {
	        for (Course course : courses) {
	            if (course.code.equalsIgnoreCase(courseCode)) {
	                return course;
	            }
	        }
	        return null;
	    }
	}
