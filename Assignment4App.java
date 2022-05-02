package com.coderscampus.com;

import java.io.IOException;
import java.util.Arrays;

public class Assignment4App {

	public static void main(String[] args) throws IOException {
		FileService service = new FileService();
		service.putMasterFileIntoArray();
		service.displaySortedArray();
		service.filterCompSciStudents();
		service.filterStatStudents();
		service.filterApMathStudents();
		service.writeToFile();
	}
}

