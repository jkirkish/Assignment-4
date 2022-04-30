package com.coderscampus.com;

import java.io.IOException;
import java.util.Arrays;

public class Assignment4App {

	// static array as a container for all of the students to sort thru
	public static Student[] students = new Student[101];

	public static void main(String[] args) throws IOException {
		FileService service = new FileService();
		service.putMasterFileIntoArray();
		students[0] = new Student(null,null,null,null);
		Arrays.sort(students);
		for(Student student : students) {
			System.out.println(student.getStudentId() + " ," +student.getName() 
			+ " ," +student.getCourse() + " ," + student.getGrade());
		}
	}
}

