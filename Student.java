package com.coderscampus.com;

public class Student implements Comparable<Student> {

	private String studentId;
	private String name;
	private String course;
	private String grade;

	//constructor that takes an Array of Strings to populate the Student array in the FileService class
	public Student(String[] values) {
		this.studentId = values[0];
		this.name = values[1];
		this.course = values[2];
		this.grade = values[3];
	}
    //constructor that is used to instantiate a Student object
	public Student(String id, String name, String course, String grade) {

		this.studentId = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}
    //getters and setters methods
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
    //to string method to print out the values in the student object
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", course=" + course + ", grade=" + grade + "]";
	}
    //CompareTo method that evaluates students grades in descending order and accounts for null values
	@Override
	public int compareTo(Student that) {

		if (this.course == null) {
			return (that.course == null) ? 0 : -1;
		}
		if (that.course == null) {
			return 1;
		}
		if (Integer.parseInt(this.grade) > (Integer.parseInt(that.grade))) {
			return -1;
		} else if (Integer.parseInt(this.grade) == (Integer.parseInt(that.grade))) {
			return 0;
		} else {
			return 1;
		}
	}
}