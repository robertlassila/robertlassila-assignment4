package com.coderscampus.assignment4;

import java.util.Arrays;
import java.util.Comparator;

public class StudentService {
	private static Student[] compSci;
	private static Student[] apMath;
	private static Student[] stats;
	private static int numberOfCompSciStudents;
	private static int numberOfStatsStudents;
	private static int numberOfApMathStudents;

	public static void determineNumberOfStudentsInEachCourse(Student[] students, int numberOfStudents) {
		int index = 1;

		while (index < numberOfStudents) {
			if (Integer.parseInt(students[index].getCourseNumber()) >= 300) {
				numberOfCompSciStudents++;
				index++;
			} else if ((Integer.parseInt(students[index].getCourseNumber()) >= 200
					&& Integer.parseInt(students[index].getCourseNumber()) <= 299)) {
				numberOfStatsStudents++;
				index++;
			} else if ((Integer.parseInt(students[index].getCourseNumber()) >= 100
					&& Integer.parseInt(students[index].getCourseNumber()) <= 199)) {
				numberOfApMathStudents++;
				index++;
			}
		}
	}

	public static void separateStudentsByClass(Student[] students, int numberOfStudents) {

		int index = 1;
		int compSciIndex = 1;
		int apMathIndex = 1;
		int statsIndex = 1;

		Student[] compSci = new Student[numberOfCompSciStudents + 1];
		Student[] apMath = new Student[numberOfApMathStudents + 1];
		Student[] stats = new Student[numberOfStatsStudents + 1];

		compSci[0] = students[0];
		apMath[0] = students[0];
		stats[0] = students[0];

		while (index < numberOfStudents) {

			if (Integer.parseInt(students[index].getCourseNumber()) >= 100
					&& Integer.parseInt(students[index].getCourseNumber()) <= 199) {
				apMath[apMathIndex] = students[index];
				apMathIndex++;
			} else if ((Integer.parseInt(students[index].getCourseNumber()) >= 200
					&& Integer.parseInt(students[index].getCourseNumber()) <= 299)) {
				stats[statsIndex] = students[index];
				statsIndex++;
			} else if ((Integer.parseInt(students[index].getCourseNumber()) >= 300
					&& Integer.parseInt(students[index].getCourseNumber()) <= 399)) {
				compSci[compSciIndex] = students[index];
				compSciIndex++;
			}
			index++;
		}
		Arrays.sort(apMath, 1, numberOfApMathStudents + 1);
		Arrays.sort(compSci, 1, numberOfCompSciStudents + 1);
		Arrays.sort(stats, 1, numberOfStatsStudents + 1);

		FileService.writeNewFiles(apMath, compSci, stats);

		for (Student student : apMath) {
			System.out.println(student.getDetails());
		}
		System.out.println("---------");
		for (Student student : compSci) {
			System.out.println(student.getDetails());
		}
		System.out.println("---------");
		for (Student student : stats) {
			System.out.println(student.getDetails());
		}
	}

}
