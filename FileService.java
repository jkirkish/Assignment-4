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
	

	// putMasterFuileIntoArray reads the master file and puts that data into the
	// students array as Students objects
	public Student[] putMasterFileIntoArray(String file) throws IOException {

		//String file = "student-master-list.csv";
		Student[] students = new Student[101];
		
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
		return students;
	}

	
	
	// csv file

	public void writeStudentsToFile(String filename,Student[] studentArr)throws IOException {
		BufferedWriter writer = null;
		try {
			//write from the compSci array to the course1 file
			writer = new BufferedWriter(new FileWriter(filename));
			for(Student stud : studentArr) {
				writer.write(stud.getStudentId() + "," + stud.getName() +"," + stud.getCourse() + "," + stud.getGrade() + "\n");
			}
		}finally {
			if(writer != null) {
				writer.close();
			}
		}
	}
	}