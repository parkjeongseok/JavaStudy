package ch07.sec07.exam02;

// 1. 부모 클래스: 모든 구성원의 공통 규격
class 사람 {
  void 출근() {
    System.out.println("출근합니다.");
  }
}

// 2. 자식 클래스들: 각자 자기 방식대로 출근 로직 구현
class 교수 extends 사람 {
  @Override
  void 출근() {
    System.out.println("교수가 연구실로 가서 논문을 씁니다.");
  }
}

class 학생 extends 사람 {
  @Override
  void 출근() {
    System.out.println("학생이 강의실로 가서 수업을 듣습니다.");
  }
}

// 3. 관리자 클래스: 두 가지 방식을 비교해 보세요.
class 출근매니저 {

  // [나쁜 예] 타입 변환을 안 썼을 때 (instanceof 노가다)
  // instanceof: 객체의 실제 타입을 확인하는 연산자입니다. (예: p가 교수냐?)
  // 이 방식은 새로운 자식이 추가될 때마다 else if를 계속 추가해야 하는 지옥이 펼쳐집니다.
  void 확인_Bad(Object obj) {
    if (obj instanceof 교수) { // 만약 들어온 객체의 알맹이가 '교수' 타입이라면?
      교수 k = (교수) obj;      // '교수'로 강제 형변환해서
      k.출근();               // 교수의 출근 기능을 실행
    } else if (obj instanceof 학생) { // 만약 알맹이가 '학생' 타입이라면?
      학생 s = (학생) obj;      // '학생'으로 강제 형변환해서
      s.출근();               // 학생의 출근 기능을 실행
    }
    // 여기에 새로운 직군(직원, 조교 등)이 생기면 이 코드를 계속 고쳐야 함 (매우 비효율적)
  }

  // [좋은 예] 자동 타입 변환을 썼을 때 (다형성 활용)
  // 매개변수를 '사람(부모)' 타입으로 받기로 약속합니다.
  // 어떤 자식이 들어오든 '사람'이라는 바구니에 자동으로 담깁니다. (자동 타입 변환)
  void 확인_Good(사람 p) {
    // 자바가 실행 시점에 p의 실제 정체(교수인지 학생인지)를 알아서 확인하고
    // 오버라이딩된 자식의 메소드를 찾아 실행해 줍니다.
    p.출근();
    // 새로운 자식이 100개 추가되어도 이 코드는 단 한 줄로 모든 게 해결됩니다.
  }
}

// 4. 메인 실행 클래스
public class Example {
  public static void main(String[] args) {
    출근매니저 manager = new 출근매니저();

    // 자식 객체들을 생성 (실제 알맹이들)
    사람 p1 = new 교수(); // 자동 타입 변환 (교수 -> 사람)
    사람 p2 = new 학생(); // 자동 타입 변환 (학생 -> 사람)

    System.out.println("--- 나쁜 예 실행 (내부에서 노가다 중) ---");
    manager.확인_Bad(p1);
    manager.확인_Bad(p2);

    System.out.println("\n--- 좋은 예 실행 (코드 한 줄로 해결) ---");
    manager.확인_Good(p1);
    manager.확인_Good(p2);
  }
}