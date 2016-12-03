package kr.ac.hansung.register.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CreditMapper implements RowMapper<CreditsPerYear> {

	@Override
	public CreditsPerYear mapRow(ResultSet rs, int rowNum) throws SQLException {

		CreditsPerYear credit = new CreditsPerYear();

		credit.setYear(rs.getInt("year"));
		credit.setSemester(rs.getString("semester"));
		credit.setCoursecode(rs.getString("courseCode"));
		credit.setCoursename(rs.getString("courseName"));
		credit.setDivision(rs.getString("division"));
		credit.setCredit(rs.getString("credit"));

		return credit;
	}
}
