package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileService {
	private static Student[] students;
	
	public FileService(String filePath) {
		int numberOfStudents = FileService.getNumberOfStudents(filePath);
		students = new Student[(numberOfStudents)];
		readFileAndCreateStudents(filePath);
		separateStudentCourseAbbreviationAndNumber(numberOfStudents);
		StudentService.determineNumberOfStudentsInEachCourse(students, numberOfStudents);
		StudentService.separateStudentsByClass(students, numberOfStudents);

	
	}
	
	public static int getNumberOfStudents(String filePath) {
		int numberOfStudents = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			while (br.readLine() != null) {
				numberOfStudents++;
			}	
			
		} catch (Exception e) {
			System.out.println("Error reading file" + e.getMessage());
		}
	
		return numberOfStudents;
	}
	
	public static void readFileAndCreateStudents(String filePath) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			int index = 0;
			
			while ((line = br.readLine()) != null) {
				
				String[] studentDetails = line.split(",");
				
				String id = studentDetails[0];
				String name = studentDetails[1];
				String course = studentDetails[2];
				String grade = studentDetails[3];
				
				students[index] = new Student(id, name, course, grade);
				index++;
				
			}
		} catch (Exception e) {
			System.out.println("Error reading file" + e.getMessage());
		}
		
	}
	public void separateStudentCourseAbbreviationAndNumber(int numberOfStudents) {
		String line;
		int index = 1;
		
		while (index < numberOfStudents) {
			line = students[index].getCourse();
			
			String[] studentCourseAbbreviationAndNumber = line.split(" ");
			
			students[index].setCourseAbbreviation(studentCourseAbbreviationAndNumber[0]);
			students[index].setCourseNumber(studentCourseAbbreviationAndNumber[1]);
			
			index++;
			
		}
		
//		for (Student student : students) {
//			line = student.getCourse();
//			
//			String[] studentCourseAbbreviationAndNumber = line.split(" ");
//			
//			student.setCourseAbbreviation(studentCourseAbbreviationAndNumber[0]);
//			student.setCourseNumber(studentCourseAbbreviationAndNumber[1]);
//			
//		}
	}

}
