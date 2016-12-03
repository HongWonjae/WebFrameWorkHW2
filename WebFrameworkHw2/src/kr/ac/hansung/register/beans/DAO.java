package kr.ac.hansung.register.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("DAO")
public class DAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from creditsperyear";     
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	public List<CreditsPerYear> getCredits() {
		String sqlStatement = "select * from creditsperyear where ";

		return jdbcTemplateObject.query(sqlStatement, new CreditMapper());
	}
	
	public boolean insert(CreditsPerYear credit) {
		int year = credit.getYear();
		String semester = credit.getSemester();		
		String courseCode = credit.getCoursecode();
		String courseName = credit.getCoursename();
		String division = credit.getDivision();
		String credits = credit.getCredit();
		String sqlStatement = "insert into creditsperyear (year, semester, courseCode, courseName, division, credits) values (?,?,?,?,?,?)";
		
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{year, semester, courseCode, courseName, division, credits}) == 1);		
	}
	
	public boolean update(CreditsPerYear credit) {
		int year = credit.getYear();
		String semester = credit.getSemester();		
		String courseCode = credit.getCoursecode();
		String courseName = credit.getCoursename();
		String division = credit.getDivision();
		String credits = credit.getCredit();		
		String sqlStatement = "update creditsperyear set year=?, semester=?, courseCode=?, courseName=?, division=?, credits=?";

		return (jdbcTemplateObject.update(sqlStatement, new Object[]{year, semester, courseCode, courseName, division, credits}) == 1);		

	}

	public boolean delete(String courseCode) {
		String sqlStatement = "delete from creditsperyear where courseCode=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{courseCode}) == 1);		

	}
}
