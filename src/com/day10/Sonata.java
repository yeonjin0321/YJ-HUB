package com.day10;

public class Sonata {
// 너는 지금 몇 km로 달리고 있니?
   int speed;
   // 자동차 마다 대표 색상이 있다.
   String carColor;
   // 4
   int wheelNum; // 0, if double 0.0
   
   public Sonata() {} 
   public Sonata(String carColor) {
      System.out.println(carColor);
      // 변수 이름 앞에 this를 붙이면 자기자신을 가리키는 수정자임
      // 그래서 전변이되는 것임.
      // this가 있을 대와 없을때의 차이를 말할 수 있어야 한다 !! 중요! 
      this.carColor = "검정색";
      System.out.println(carColor); // 지역변수
   }
 public Sonata(int speed, String carColor, int wheelNum) {
    this.speed = speed;
    this.carColor  = carColor;
    this.wheelNum = wheelNum;
    
 }
    @Override
 public String toString() {
    return  " 내 자동차는 현재" +speed+"로 달리고 있고 바퀴수는 "+wheelNum+" 이고, 자동차 색상은 "+carColor+" 입니다.";
 }

}