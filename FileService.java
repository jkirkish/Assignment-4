package com.coderscampus.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

	public void putMasterFileIntoArray() throws IOException {

		String file = "student-master-list.csv";

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				Assignment4App.students[i] = new Student(line.split(","));
				System.out.println(i + ": " + Assignment4App.students[i]);
				i++;
			}
			
		} finally {
			System.out.println("User Array Populated");
			if (br != null)
				br.close();
		}
	}

	public void writeToFile(String file) throws IOException {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("test");
		} finally {
			if (writer != null)
				writer.close();
		}
	}
}

/*public static void main (String[] args) throws IOException {
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter("data.txt"));
			writer.write("This is a test string that will be output into a file.\n");
			writer.write("Is this line of text on a new line?");
		} finally {
			if (writer != null) writer.close();
		}
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			System.out.println(reader.readLine());
		} finally {
			if (reader != null) reader.close();
		}
	}
 * 
 */
