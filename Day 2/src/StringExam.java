
public class StringExam {
	public static void main(String[] args) {

		String str1 = new String("Superman");
		String str2 = new String("Superman");

		System.out.println(str1);
		System.out.println(str1);

		if (str1 == str2) { // string 은 == 시 위치비교
			System.out.println("same");
		} else {
			System.out.println("diff"); //str1, str2는 다른 객체라서 레퍼런스 비교하면 다르다고 나옴.
		}

		if (str1.equals(str2)) { // 값을 받고싶으면 equals로 비교
			System.out.println("same");	//값은 같다고 나옴
		} else {
			System.out.println("diff");
		}

		String str3 = "Batman";
		String str4 = "Batman";
		String str5 = "Superman";

		if (str3 == str4) { //new 선언한 게 아니므로 이미 같은 값 가지고 있는 str3을 참조함.
			System.out.println("same");
		} else {
			System.out.println("diff");
		}

		if (str3.equals(str4)) { //내용도 같고 주소도 같음.
			System.out.println("same");
		} else {
			System.out.println("diff");
		}
		str4 = "pororo"; // string class는 데이터 변경 불가 (한번 들어가면 변경 불가) -> 
		//뽀로로를 새로 만들으라는 것임. / 문자열은 값을 바꿀 수 없다.

		if (str3 == str4) {
			System.out.println("same");
		} else {
			System.out.println("diff"); //주소가 바뀌었음.
		}
		System.out.println(str4);
	}

}
