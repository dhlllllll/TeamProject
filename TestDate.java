package team_test;

import java.util.Calendar;
import java.util.Scanner;

public class TestDate {

	public static void main(String[] args) {
		annualLeave();
	}
	public static void annualLeave() {		
		Scanner sc = new Scanner(System.in);
		
	while(true) {
		System.out.println("입사날짜를 입력해주세요. 예)20150310");
		String enterDate = sc.next();
		//입력형식맞지않으면 다시 입력
		if(enterDate == null || enterDate.length()!=8) {
			System.out.println("\n **다시 형식에 맞게 입력해주세요**");
			continue;
		} else {
		while(true) {
		System.out.println("조회날짜를 입력해주세요. 예)20221209");
		String searchDate = sc.next();
		if(searchDate == null || searchDate.length()!=8) {
			System.out.println("\n **다시 형식에 맞게 입력해주세요**");
			continue;
		} else {
		int resultDate = getDayDiff(enterDate,searchDate);
		//System.out.println(resultDate);
			
	
	//연차 개수 구하기 
	int vacationNum = 0;
	if(365<=resultDate && resultDate<1095) {
		vacationNum = 15;
	} else if(1095<=resultDate && resultDate<1825) {
		vacationNum = 16;
	} else if(1825<=resultDate && resultDate<2555) {
		vacationNum = 17;
	} else if(2555<=resultDate && resultDate<3285) {
		vacationNum = 18;
	} else if(3285<=resultDate && resultDate<4015) {
		vacationNum = 19;
	}
	
	//햇수 구하기 
	int countNum = 0;
	countNum = resultDate/365;
	
	System.out.println("총 연차/휴가 개수 : " + vacationNum);
	System.out.println("근무 일수 : ");
	System.out.println("햇수 : " + countNum + "년 차");
	break;
				}
			}
		}
	}
}		
	
	static int getDayDiff(String date1,String date2) {
		int diff = 0;
		int diff3 = 0;
		
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
		//diff3 = (int)((diff/1000) /60/60/24/30);
		
		return diff2;
	}
	
}
