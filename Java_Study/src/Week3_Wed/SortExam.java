package Week3_Wed;

public class SortExam {
	public static void main(String[] args) {

		int data[] = { 90, 78, 100, 30, 35 };

		bubbleSort(data);
		
		System.out.print("정렬된 수 :  ");
		for (int i : data)
			System.out.print(i + "  ");

	}

	static void bubbleSort(int[] a) {
		int count = 0;	//바꾼 횟수를 담는 변수
		int count1 = 0;  //비교 횟수를 담는 변수
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j <a.length-1-i;  j++) {
				count1 ++;
				if (a[j] > a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					count++;
				}
			}
		}
		System.out.println("변경 횟수 : "+ count +"  비교 횟수 : " + count1);
	}
}
