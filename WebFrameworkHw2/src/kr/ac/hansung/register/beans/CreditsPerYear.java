package kr.ac.hansung.register.beans;

public class CreditsPerYear {
	
	private int year;
	private String semester;
	private String coursecode;
	private String coursename;
	private String division;
	private String credit;

	public CreditsPerYear() {		

	}
	
	public CreditsPerYear(int year, String semester, String coursecode, String coursename, String division,
			String credit) {
		super();
		this.year = year;
		this.semester = semester;
		this.coursecode = coursecode;
		this.coursename = coursename;
		this.division = division;
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "CreditsPerYear [year=" + year + ", semester=" + semester + ", coursecode=" + coursecode
				+ ", coursename=" + coursename + ", division=" + division + ", credit=" + credit + "]";
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

	public String getCoursecode() {
		return coursecode;
	}

	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

}
