package kr.ac.hansung.register.beans;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("kr/ac/hansung/register/beans/beans.xml");
		
		DAO dao = (DAO)context.getBean("DAO");
		System.out.println("The record count is " + dao.getRowCount());
		
		List<CreditsPerYear> creditList = dao.getCredits();
		
		for(CreditsPerYear credit: creditList) {
			System.out.println(credit);
		}
		
		CreditsPerYear credits = new CreditsPerYear(2017, "1", "CSE70007", "Ä¸½ºÅæµðÀÚÀÎ1", "ÀüÁö", "3");
		if(dao.insert(credits)) {
			System.out.println("Object is inserted Sucessfully");
		}
		else {
			System.out.println("Object insertion Failed");
		}
		
		context.close();
	}

}
