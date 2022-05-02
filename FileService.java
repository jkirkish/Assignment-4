package com.coderscampus.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileService {
	// array of type Students is to be populated so that this data can be further
	// evaluated
	private Student[] students = new Student[101];
	private Student[] compSci = new Student[35];// compSci only takes students who are in computer science courses
	private Student[] stats = new Student[34];// stats array only takes students in statistics courses
	private Student[] math = new Student[34];// math array only takes students in math courses

	// putMasterFuileIntoArray reads the master file and puts that data into the
	// students array as Students objects
	public void putMasterFileIntoArray() throws IOException {

		String file = "student-master-list.csv";

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				students[i] = new Student(line.split(","));
				System.out.println(i + ": " + students[i]);
				i++;
			}
			// elements 0 in the students array is replaced with nulls because column titles
			// are insignificant with sorting students
			students[0] = new Student(null, null, null, null);
		} finally {
			System.out.println("User Array Populated");
			if (br != null)
				br.close();
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
		System.out.println(count);
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
		System.out.println(count);
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
	// this method writes the same data that is displayed, only to be viewed in a
	// csv file

	public void writeToFile() throws IOException {
		BufferedWriter writer = null;
		BufferedWriter writer1 = null;
		BufferedWriter writer2 = null;
		try {
			// write from the compSci array to the course1 file
			writer = new BufferedWriter(new FileWriter("course1.csv"));
			for (Student comp : compSci) {
				writer.write(comp.getStudentId() + "," + comp.getName() + "," + comp.getCourse() + "," + comp.getGrade()
						+ "\n");
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		try {
			// write from the stats array to the course2 file
			writer1 = new BufferedWriter(new FileWriter("course2.csv"));
			for (Student stat : stats) {
				writer1.write(stat.getStudentId() + "," + stat.getName() + "," + stat.getCourse() + ","
						+ stat.getGrade() + "\n");
			}
		} finally {
			if (writer1 != null)
				writer1.close();
		}
		try {
			// write from the ma array to the course2 file
			writer2 = new BufferedWriter(new FileWriter("course3.csv"));
			for (Student ma : math) {
				writer2.write(
						ma.getStudentId() + "," + ma.getName() + "," + ma.getCourse() + "," + ma.getGrade() + "\n");
			}
		} finally {
			if (writer2 != null)
				writer2.close();
		}
	}
}
