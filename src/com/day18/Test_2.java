package com.day18;
//구구단 중에서 시작단과 끝단을 입력받아서  출력하는 프로그램을 작성하시오.

//whlie문 사용 하여 구구단 출력해보기.

public class Test_2 {
	public static void main(String[] args) {

		 int i,j;
         i=1; j=1;
         while(i<10)
         {
             while(j<10){
            	 System.out.print(j+" X "+i+" = "+(i*j)+"\t");

                  j++;
             }
             System.out.println();
             j=1; // 초기화
             i++;
         }

	}
}