package com.coderscampus.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StudentService {

	private Student[] students = new Student[101];
	private Student[] compSci = new Student[35];// compSci only takes students who are in computer science courses
	private Student[] stats = new Student[34];// stats array only takes students in statistics courses
	private Student[] math = new Student[34];// math array only takes students in math courses

	// putMasterFuileIntoArray reads the master file and puts that data into the
	// students array as Students objects
	public StudentService() {
		loadStudents("student-master-list.csv");
	}

	private void loadStudents(String fileName) {
		FileService fileService = new FileService();
		try {
			students = fileService.putMasterFileIntoArray(fileName);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void segregateStudents() {
		/*load students-already laoded in constructor
		 * sort students Once
		 * segregate into appropriate array holders
		 * write each array to appropriate csv file
		 */
		Arrays.sort(students);
		
		filterCompSciStudents();
		filterStatStudents();
		filterApMathStudents();
		
		FileService fileService = new FileService();
		try {
			fileService.writeStudentsToFile("course1-r.csv",compSci);
			fileService.writeStudentsToFile("course2-r.csv",stats);
			fileService.writeStudentsToFile("course3-r.csv",math);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	// this methods isolates computer science students and put them into the compSci
	// Array after being sorted descending grades
	public Student[] filterCompSciStudents() {
		int count = 0;
		for (int i = 1; i < students.length; i++) {
			if (students[i].getCourse().startsWith("C")) {
				count++;
				compSci[count] = students[i];
			}
		}
		// the column titles in element 0 are put back in
		compSci[0] = new Student("StudentID", "Student Name", "Course", "Grade");
		for (int i = 0; i < compSci.length; i++) {
			System.out.println(compSci[i]);
		}
		return compSci;
	}

	// this methods isolates stat students and put them into the stat Array after
	// being sorted descending grades
	public Student[] filterStatStudents() {
		int count = 0;
		for (int i = 1; i < students.length; i++) {
			if (students[i].getCourse().startsWith("S")) {
				count++;
				stats[count] = students[i];
			}
		}
		stats[0] = new Student("StudentID", "Student Name", "Course", "Grade");
		for (int i = 0; i < stats.length; i++) {
			System.out.println(stats[i]);
		}
		return stats;
	}

	// this methods isolates math students and put them into the math Array after
	// being sorted descending grades
	public Student[] filterApMathStudents() {
		int count = 0;
		for (int i = 1; i < students.length; i++) {
			if (students[i].getCourse().startsWith("A")) {
				count++;
				math[count] = students[i];
			}
		}
		math[0] = new Student("StudentID", "Student Name", "Course", "Grade");
		for (int i = 0; i < math.length; i++) {
			System.out.println(math[i]);
		}
		return math;
	}

	// this methods displays and prints out all of the arrays and their contents for
	// validation
	public void displaySortedArray() {
		Arrays.sort(students);
		for (Student student : students) {
			System.out.println(student.getStudentId() + " ," + student.getName() + " ," + student.getCourse() + " ,"
					+ student.getGrade());
		}

	}
}
