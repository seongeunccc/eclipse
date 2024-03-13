package Day4;
//한페이지에 클래스를 여러개 만들 때는 퍼블릭 클래스는 하나만 사용 가능하다. 

class A {
	private int a;

	public A() {

	}

	public void setA(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}
}

public class HasA {

	private String name;
	private A age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age.setA(age);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return this.age.getA();
	}

	// 생성자 함수  - 객체 생성시 생성자 함수를 봐야함.

	public HasA() {
		name = "";
		age = new A();
	}

	
	
	public static void main(String[] args) {

		HasA has = new HasA();
	
		has.setName("superman");
		has.setAge(100000);

		System.out.println(has.getName());
		System.out.println(has.getAge());

		
	}

}
