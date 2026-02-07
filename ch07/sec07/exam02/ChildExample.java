package ch07.sec07.exam02;

public class ChildExample {
  public static void main(String[] args) {
    // 자식 개체 생성
    Child child = new Child();

    // 자동 타입 변환
    Parent parent = child;

    // 메소드 호출
    parent.method();
    parent.method2();
    // parnet.method3(); - 호출 불가능
    child.method3();
  }
}
