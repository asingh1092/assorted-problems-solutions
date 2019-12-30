package com.singh.EPI.Searching;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {

	public String name;
	public double gradePointAverage;

	Student(String name, double gradePointAverage) {
		this.name = name;
		this.gradePointAverage = gradePointAverage;
	}

	private static final Comparator<Student> compGPA = (a, b) -> {
		if (a.gradePointAverage != b.gradePointAverage) {
			return Double.compare(b.gradePointAverage, a.gradePointAverage);
		}
		return a.name.compareTo(b.name);
	};
	
	public static boolean searchStudent(List<Student> students, Student target, Comparator<Student> compGPA) {
		return Collections.binarySearch(students, target, compGPA) >= 0;
	}
}
