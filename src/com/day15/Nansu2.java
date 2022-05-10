package com.day15;

//다음은 우리반 학생들의  자바, html, 오라클과목에 대한 성적표 이다.
//총점, 평균,석차를 구하시오
public class Nansu2 {

	public static void main(String[] args) {

		int score[][] = {
				        { 100, 90, 80 }, 
			        	{ 85, 90, 80 }, 
				        { 70, 70, 80 }, 
				        { 90, 60, 65 }, 
				        { 65, 80, 70 }  
				        };

		 int sum =0;
		 double avg =  0.0;
		 int avg_su =0;
		 int rank = 0;
		 
		 for(int i=0; i<score.length;i++) {
			 for(int j=0; j<score[i].length;j++) {
				 sum += score[i][j]; //총합 누적
				 avg_su += 1; // 평균을 내기 위해 총 갯수 구하기
				 
			 }
		 }
		 avg = sum / avg_su; //평균값 도출
		 
		 System.out.println("총합: "+sum+"점");
		 System.out.println("평균: "+avg+"점");
	}
}