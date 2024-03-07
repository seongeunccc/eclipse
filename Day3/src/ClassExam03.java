/*
 * this -> instance 메소드의 첫 번째 매개변수로 '항상' 존재. 
 * instance 메소드에는 있고 static 메소드에는 없음.(static은 this 존재하지 않음)
 * this = 자기 자신에 접근하는 레퍼런스 변수(heap 영역에 접근하는 변수)
 * ce.setNum1(10); 하면 안보이지만 매개변수로 'ce'를 반환 
 * this 함수는 선언 불가, 사용만 가능 // 자동으로 만들기 때문에 에러남. 
 * 인스턴스 변수가 저장되는 메모리는 한개지만 객체처럼 여러군데서 사용가능한 윈리가 this 덕분임
 * 	스테틱은 실제로도 한개; 외부에서 참조 불가 (주소가 없으므로)
 */

/* [강사님이 정리해주진 this]
 * this :	자기 자신을 접근하는 객체 레퍼런스 변수
 * 			인스턴스 메소드의 첫 번째 매개변수로 항상 존재
 * 			선언할 수는 없고 사용만 가능
 * 			객체 구별해주는 역할 => 디폴트 기능
 * 
 * 			[this를 명시적으로 사용하는 경우] : 내꺼를 명시적으로 구분해야 할 때 
 * 			1. 필드명과 지역변수 이름이 같을 경우 필드를 구분하기 위해 사용
 *			2. 인스턴스 메소드에서 자기 자신의 객체를 리턴하고 싶을 때
 * 
 * this() : this 호출 
 * - 자신의 또 다른 생성자를 호출
 *
*/
package src;

public class ClassExam03 {
	
	int a;

	public int getA() {
		
		return a;
	}

	public void setA(int a) { //
		this.a = a;		//this를 안붙이면 this 가 지역변수로 들어가니까 this를 붙여야 ce의 필드 a라는 것을 알 수 있게 됨
		// this 안붙이면 int a= a가 됨.  == 지역변수와 필드 이름이 똑같을 때 필드를 명시적으로 표현하고 싶을 때 this 를 사용해야 함
	}
	
	
	//자기 자신의 타입을 보내줄 때 this 사용
	public ClassExam03 getObject() { 
		return this;
	}
	
	
	
	
	public static void main(String[] args) {
		ClassExam03 ce = new ClassExam03();  //객체 선언.. ! 불러오기..!
		ce.setA(100);
		System.out.println(ce.getA());
		
		ClassExam03 ce1 = ce.getObject();
		System.out.println(ce);
		System.out.println(ce1);
	}
	
}
