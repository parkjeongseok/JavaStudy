package ch07.sec07.exam03;

public class ChildExample {
  public static void main(String[] args) {
    // 객체 생성 및 자동 타입 변환
    Parent parent = new Child();

    // Parent 타입으로 필드와 메소드 사용
    parent.field1 = "data1";
    parent.method1();
    parent.method2();
    // 자식 클래스를 부모 클래스로 자동 타입 변환을 시켰기 때문에
    // 자식 클래스에 선언된 변수와 메소드는 사용할 수 없다.
    // parent.field2 = "data2"; - 불가능
    // parent.method3(); - 불가능

    // 강제 타입 변환
    Child child = (Child) parent;
    child.field2 = "data2";
    child.method3();
  }
}
