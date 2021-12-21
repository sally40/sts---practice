package net.skhu.dto;

public class Lecture {
	int id;
	int year;
	String semester;
	String gubun;
	String bunban;
	int courseId;
	String sigan;
	String courseName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getBunban() {
		return bunban;
	}

	public void setBunban(String bunban) {
		this.bunban = bunban;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getSigan() {
		return sigan;
	}

	public void setSigan(String sigan) {
		this.sigan = sigan;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
