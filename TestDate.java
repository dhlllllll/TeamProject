package test;

import java.util.Calendar;

public class TestDate {

	public static void main(String[] args) {
		System.out.println(getDayDiff("20211101", "20221130"));
	}
	
	static int getDayDiff(String date1,String date2) {
		int diff = 0;
		
		int year1 = Integer.parseInt(date1.substring(0, 4));
		int month1 = Integer.parseInt(date1.substring(4, 6))-1;
		int day1 = Integer.parseInt(date1.substring(6, 8));
		int year2 = Integer.parseInt(date2.substring(0, 4));
		int month2 = Integer.parseInt(date2.substring(4, 6))-1;
		int day2 = Integer.parseInt(date2.substring(6, 8));
		
		Calendar newDate1 = Calendar.getInstance();
		Calendar newDate2 = Calendar.getInstance();
		//날짜 초기화
		newDate1.clear();
		newDate2.clear();
		//날짜 설정
		newDate1.set(year1, month1, day1);
		newDate2.set(year2, month2, day2);
		//날짜 차이 구하기
		diff = (int)((newDate1.getTimeInMillis() - newDate2.getTimeInMillis())/(24*60*60*1000));
		int diff2 = Math.abs(diff);
		
		return diff2;
	}

}
