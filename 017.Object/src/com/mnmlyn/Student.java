package com.mnmlyn;

public class Student extends Human {
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Student(String name, int age) {
		super(name, age);
	}
	
}
