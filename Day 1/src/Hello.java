/* java는 100% 상속구조
 * java는 100% 객체 지향 언어 -> 무조건 객체를 사용
 * 
 * 시작과 끝을 담당하는 함수 => main 함수
 * 함수 => function(c, c++에서는 펑션) => method(java에서 메소드라고 부름)
 * 
 * 이름 규칙
 * 1. 클래스 : 첫글자는 대문자로 작성
 * 2. 메소드, 변수 : 소문자로 작성 / 변수 : 상수를 저장하는 메모리 공간
 * 3. 상수는 전부 대문자(MAX)/ 상수 : 변하지 않는 값  
 * 4. 단어와 단어가 이어질 때 두번째 단어의 첫글자는 대문자로 작성 : 이것은 문법이라기보다는 약속 BlackWhite blackWhite
 * 
 * DataType
 * 1. 
 * 		문자형 char 2byte(유니코드를 사용하기 위해 바이트 사용)
 * 		정수형 byte, short, int, long 4byte 3
 * 		실수형 float, double 3.7
 * 
 * 2. Reference Type : 레퍼런스 변수를 사용한다
 * 	- 배열
 * 	- 객체
 * 	- enum(열거형)
 * 
 * 	형변환 casting
 * 	1. 자동현형환 3+3.2 / int+double = 에러가 나는게 맞지만 int + double 을 같은 형으로 바꿈/큰거 기준으로
 * 	2. 강제형변환 3/4=0 int/int = 0.75(에러, 타입이 다름)
 * 	double (3)/double(4)/ 원할 때 직접 형 변환
 * 
 */

// 데이터들은 주로 String Type를 주로 사용함 / 제일 많이 사용하는 클래스 = String
// 사용자를 고려해서 객체를 만들어야함.


public class Hello {   //Hello는 내가 만든 클래스, 밑에 있는 String, System 은 기존에 설정되어있는 클래스
	
	public static void main(String []args) { //프로그램을 시작하고 끝내줌, 프로그램 전체에 메인은 한개만 있어야 함, 문자 배열을 받는다.
		int num; //파이썬을 제외하고는 문장 끝에 세미콜론을 넣어야 함 / 이클립스는 오류나면 그 때 실시간으로 에러 표시해 줌(기본문법, 100%는 아님)
		num = 10;
		double a = 10.7;
		int b = 5;
		int c = 4;
		
		char ch = 'A'; //변수는 선언과 함께 초기화도 가능하고, 선언 후에 초기화도 가능하다
		System.out.println(num);  //out은 static 이다. 바로 썼으니까 / 클래스 이름을 통해서 가는 것은 스태틱
		System.out.println((int)ch); // A의 아스키코드 65가 표출됨
		
		
		Hello hello;  //hello는 레퍼런스 변수(객체에 접근할 수 있는 변수)
		hello = new Hello(); //객체 생성 stack 영역과 Heap 영역에 데이터 있는지 확인 /heap 영역에 데이터 누락되는 경우 자주 발생 / heap 영역은 new로 선언
		
		System.out.print("a".repeat(8));
		System.out.print(c/b);
		
	}
	// main 함수가 끝나는 시점
	//dataType 변수명 ;
	// 뱐수명 = 값; = 초기화(값을 넣다)
	//지역변수 local variable : method 안에 선언되어지는 변수
	//       	  			: 꼭 초기화를 해야함. / 안하면 에러남
	
}
	

